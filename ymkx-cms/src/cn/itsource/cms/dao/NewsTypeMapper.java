package cn.itsource.cms.dao;

import java.util.List;

import cn.itsource.cms.model.NewsType;

public interface NewsTypeMapper {

	/**
	 * 查询所有
	 * @return
	 */
	List<NewsType> findAll();
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	NewsType findById(Long id);
}