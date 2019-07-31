package cn.itsource.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itsource.cms.model.Student;
import cn.itsource.cms.service.StudentService;

@Controller
public class HelloController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		List<Student> list = studentService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("hello");		
		return mav;
	}
}