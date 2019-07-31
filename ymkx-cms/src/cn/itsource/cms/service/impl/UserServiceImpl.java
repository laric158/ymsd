package cn.itsource.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itsource.cms.dao.UserMapper;
import cn.itsource.cms.model.User;
import cn.itsource.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	@Override
	public void insertUser(String username, String password) {
		User u = new User();
		u.setName(username);
		u.setPassword(password);
		u.setType(1);
		u.setIsLogin(0);
		userMapper.insertUser(u);
	}

}
