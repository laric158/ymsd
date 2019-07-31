package cn.itsource.cms.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itsource.cms.model.User;
import cn.itsource.cms.service.UserService;

@Controller
public class UserController {

	public Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	/**
	 * 注册
	 * 
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(String username, String password) {
		ModelAndView mav = new ModelAndView();
		/**
		 * 1、验证用户名、密码是否为空 2、验证用户名释放存在
		 */
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			mav.setViewName("../../register");
			mav.addObject("errMsg", "用户名或者密码为空，注册失败");
			return mav;
		}
		User user = userService.findUserByUsername(username);
		if (Objects.nonNull(user)) {
			mav.setViewName("../../register");
			mav.addObject("errMsg", "用户名已存在");
			return mav;
		}
		/**
		 * 验证通过，保存进数据库 这时候要考虑密码的问题了 都是经过加密的 MD5加密
		 * 
		 */
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		// 保存
		userService.insertUser(username, md5Password);

		mav.setViewName("redirect:login.jsp");
		return mav;
	}

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(String username, String password, HttpServletRequest request) {
		log.info("######执行登录方法,name=" + username);

		ModelAndView mav = new ModelAndView();
		if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)) {
			log.info("######执行注册功能，用户名" + username + "已经存在，返回注册页面");
			mav.addObject("errMsg","用户名或者密码为空，登录失败");
			mav.setViewName("redirect:login.jsp");
			return mav;
		}
		User user = userService.findUserByUsername(username);
		if(Objects.isNull(user)) {
			mav.addObject("errMsg","用户名或密码错误");
			mav.setViewName("redirect:login.jsp");
			return mav;
		}
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		if(!md5Password.equals(user.getPassword())) {
			if(Objects.isNull(user)) {
				mav.addObject("errMsg","用户名或密码错误");
				mav.setViewName("redirect:login.jsp");
				return mav;
			}
		}
		//登录成功，往session中放值
		request.getSession().setAttribute("user", user);

		mav.setViewName("system/index");
		return mav;
	}
}
