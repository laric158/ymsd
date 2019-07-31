package cn.itsource.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统管理的控制器
 * @author st
 *
 */
@Controller
public class SystemController {

	@RequestMapping("/system_index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/index");
		return mav;
	}

	@RequestMapping("/system_main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/main");
		return mav;
	}

	@RequestMapping("/system_top")
	public ModelAndView top() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/top");
		return mav;
	}
	@RequestMapping("/system_menu")
	public ModelAndView menu() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/menu");
		return mav;
	}
}