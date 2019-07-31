package cn.itsource.cms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itsource.cms.model.News;
import cn.itsource.cms.model.NewsType;
import cn.itsource.cms.model.Page;
import cn.itsource.cms.model.User;
import cn.itsource.cms.service.NewsService;

/**
 * 新闻的控制器
 * @author st
 *
 */
@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping("newsList")
	public ModelAndView newsList(HttpServletRequest req) {
		//查询数据
		ModelAndView mav = new ModelAndView();
		List<News> list = newsService.findAll();
		mav.addObject("list", list);
		
		//分页信息
		Page page = newsService.findByParameterAndLimit(req);
		mav.addObject("page", page);
		
		//新闻类型下拉列表
		List<NewsType> newsTypeList = newsService.findNewTypeAll();
		mav.addObject("newsTypeList", newsTypeList);
		mav.setViewName("system/newsList");
		return mav;
	}
	
	@RequestMapping("addNews")
	public ModelAndView addNews(HttpServletRequest request) {
		//查询数据
		ModelAndView mav = new ModelAndView();
		List<NewsType> newsTypeList = newsService.findNewTypeAll();
		mav.addObject("newsTypeList", newsTypeList);
		
		String _id = request.getParameter("id");
		//如果ID不为空
		if(!StringUtils.isEmpty(_id)) {
			News news = newsService.findById(Long.parseLong(_id));
			mav.addObject("news", news);
		}
		mav.setViewName("system/newsEdit");
		return mav;
	}
	
	/**
	 * 新增或跟新新闻
	 * @param request
	 * @return
	 */
	@RequestMapping("editNews")
	public ModelAndView editNews(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		News news = getNewsByReq(request);
		newsService.editNews(news);
		//重新查询新闻信息
		Page page = newsService.findByParameterAndLimit(request);
		mav.addObject("page",page);

		List<NewsType> newsTypeList = newsService.findNewTypeAll();
		mav.addObject("newsTypeList", newsTypeList);
		mav.setViewName("system/newsList");
		return mav;
	}

	public News getNewsByReq(HttpServletRequest request){
		News news = new News();
		User user =(User) request.getSession().getAttribute("user");
		String _id = request.getParameter("_id");
		String _title = request.getParameter("_title");
		String _type_id = request.getParameter("_type_id");
		String _isRecommend = request.getParameter("_isRecommend");
		String _context = request.getParameter("_context");
		if(!StringUtils.isEmpty(_id)) {
			news.setId(Long.parseLong(_id));
		}
		news.setContext(_context);
		news.setRecommend(Boolean.valueOf(_isRecommend));
		news.setTitle(_title);
		news.setType_id(Long.valueOf(_type_id));
		news.setViewCount(0);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		news.setInputDate(sdf.format(date));
		news.setUser_id(user.getId());
		return news;
	}
}