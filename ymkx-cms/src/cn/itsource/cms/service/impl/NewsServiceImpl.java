package cn.itsource.cms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.itsource.cms.dao.NewsMapper;
import cn.itsource.cms.dao.NewsTypeMapper;
import cn.itsource.cms.dao.UserMapper;
import cn.itsource.cms.model.News;
import cn.itsource.cms.model.NewsType;
import cn.itsource.cms.model.Page;
import cn.itsource.cms.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private NewsTypeMapper newsTypeMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<News> findAll() {
		List<News> list = newsMapper.findAll();
		findCorrelated(list);
		return list;
	}

	/**
	 * 查询对应的外部关联
	 * 
	 * @param list
	 */
	private void findCorrelated(List<News> list) {

		list.forEach(news -> {
			news.setNewsType(newsTypeMapper.findById(news.getType_id()));
			news.setUser(userMapper.findById(news.getUser_id()));
		});
	}

	@Override
	public List<NewsType> findNewTypeAll() {
		return newsTypeMapper.findAll();
	}

	@Override
	public Page findByParameterAndLimit(HttpServletRequest req) {
		Page page = new Page();
		// 获取高级查询条件
		String type = req.getParameter("type");
		String isRecommend = req.getParameter("isRecommend");
		String keyword = req.getParameter("keyword");
		// 判断与封装
		Map<String, Object> param = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(type)) {
			param.put("type", Long.valueOf(type));
		}
		if (!StringUtils.isEmpty(isRecommend)) {
			param.put("isRecommend", isRecommend);
		}
		if (!StringUtils.isEmpty(keyword)) {
			param.put("keyword", "%" + keyword + "%");
		}

		// 每页条数,设置为10
		int size = 10;
		// 获取总数--带条件的
		int count = newsMapper.getCountByParam(param);
		page.setPageCount(count);
		// 计算总页数
		int totalPage = (count - 1) / size + 1;
		page.setTotalPage(totalPage);

		// 获取当前页码,第一次为null,设置为1
		String pageNo = req.getParameter("pageNo");
		int pageNoNum;
		if (StringUtils.isEmpty(pageNo)) {
			pageNoNum = 1;
		} else {
			pageNoNum = Integer.parseInt(pageNo);
			if (pageNoNum < 1) {
				pageNoNum = 1;
			}
		}
		if (pageNoNum > totalPage) {
			pageNoNum = totalPage;
		}
		// 开始行数
		int start = (pageNoNum - 1) * size;

		param.put("start", start);
		param.put("size", size);

		List<News> list = newsMapper.findByParamAndList(param);

		findCorrelated(list);
		page.setList(list);
		// 设置当前页码
		page.setPageNo(pageNoNum);
		return page;
	}

	@Override
	public void editNews(News news) {
		//判断ID，确定是新增还是修改
		if(Objects.isNull(news.getId())) {
			newsMapper.addNews(news);
		}else {
			newsMapper.updateNews(news);
		}
	}

	@Override
	public News findById(long id) {
		
		return newsMapper.findById(id);
	}

	@Override
	public List<News> queryNewsByIsRecommend() {
		return newsMapper.findRecommendTop5News();
	}

	@Override
	public List<News> queryNewsByInputDate() {
		return newsMapper.findNewestTop5News();
	}

	@Override
	public List<News> queryNewsByviewCount() {
		return newsMapper.findHotTop5News();
	}

}
