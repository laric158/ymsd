package cn.itsource.cms.dao;

import java.util.List;
import java.util.Map;

import cn.itsource.cms.model.News;

/**
 * 新闻对应数据库接口类
 * 
 * @author st
 *
 */
public interface NewsMapper {
	/**
	 * 查询所有的
	 * 
	 * @return
	 */
	List<News> findAll();

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	News findById(Long id);

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 */
	void deleteById(Long id);

	/**
	 * 添加新闻
	 * 
	 * @param news
	 */
	void addNews(News news);

	/**
	 * 修改新闻
	 * 
	 * @param news
	 */
	void updateNews(News news);

	/**
	 * 带条件查询--总条数
	 * 
	 * @param param
	 * @return
	 */
	int getCountByParam(Map<String, Object> param);

	/**
	 * 带条件查询-列表
	 * 
	 * @param param
	 * @return
	 */
	List<News> findByParamAndList(Map<String, Object> param);

	/**
	 * 推荐
	 * 
	 * @return
	 */
	List<News> findRecommendTop5News();

	/**
	 * 最新
	 * 
	 * @return
	 */
	List<News> findNewestTop5News();

	/**
	 * 最热
	 * 
	 * @return
	 */
	List<News> findHotTop5News();
}
