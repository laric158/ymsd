package cn.itsource.cms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.itsource.cms.model.News;
import cn.itsource.cms.model.NewsType;
import cn.itsource.cms.model.Page;

public interface NewsService {

	List<News> findAll();

	/**
	 * 新闻类型查询所有
	 * 
	 * @return
	 */
	List<NewsType> findNewTypeAll();

	/**
	 * 分页信息
	 * 
	 * @param req
	 * @return
	 */
	Page findByParameterAndLimit(HttpServletRequest req);

	/**
	 * 编辑新闻
	 * 
	 * @param news
	 */
	void editNews(News news);

	/**
	 * 根据ID查询单个
	 * 
	 * @param parseLong
	 * @return
	 */
	News findById(long parseLong);

	/**
	 * 推荐新闻Top5
	 * 
	 * @return
	 */
	List<News> queryNewsByIsRecommend();

	/**
	 * 最新新闻Top5
	 * 
	 * @return
	 */
	List<News> queryNewsByInputDate();

	/**
	 * 热门新闻Top5
	 * 
	 * @return
	 */
	List<News> queryNewsByviewCount();

}
