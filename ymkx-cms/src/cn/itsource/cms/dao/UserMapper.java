package cn.itsource.cms.dao;

import cn.itsource.cms.model.User;

public interface UserMapper {
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	User findById(Long id);

	/**
	 * 根据用户名查找
	 * @param id
	 * @return
	 */
	User findUserByUsername(String username);

	/**
	 * 新增
	 * @param u
	 */
	void insertUser(User u);
}
