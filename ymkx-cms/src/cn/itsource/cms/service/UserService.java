package cn.itsource.cms.service;

import cn.itsource.cms.model.User;

public interface UserService {

	/**
	 * 根据用户名获取用户
	 * 
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);

	/**
	 * 新增用户
	 * @param username
	 * @param md5Password
	 */
	void insertUser(String username, String md5Password);

}
