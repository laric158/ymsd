package cn.itsource.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itsource.cms.model.News;
import cn.itsource.cms.service.NewsService;

/**
 * 首页
 * @author st
 *
 */
@Controller
public class IndexController {

	@Autowired
	NewsService newsService;
	
	@RequestMapping("wellcome")
	public ModelAndView wellcome(){
		ModelAndView mv = new ModelAndView();
		//1.获取推荐新闻
		List<News> newsByIsRecommend = newsService.queryNewsByIsRecommend();
		mv.addObject("newsByIsRecommend",newsByIsRecommend);
		//2.获取最新新闻
		List<News> newsByInputDate = newsService.queryNewsByInputDate();
		mv.addObject("newsByInputDate",newsByInputDate);
		//3.热门新闻
		List<News> newsByviewCount = newsService.queryNewsByviewCount();
		mv.addObject("newsByviewCount",newsByviewCount);
		
		mv.setViewName("front/wellcome");
		return mv;
	}

	@RequestMapping("details")
	public ModelAndView details(String id){
		ModelAndView mv = new ModelAndView();
		if(!StringUtils.isEmpty(id)){
			News news = newsService.findById(Long.valueOf(id));
			mv.addObject("news",news);
		}
		mv.setViewName("front/details");
		return mv;
	}
}
