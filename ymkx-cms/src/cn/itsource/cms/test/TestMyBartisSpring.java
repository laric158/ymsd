package cn.itsource.cms.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itsource.cms.model.Student;
import cn.itsource.cms.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicactionContext.xml")
public class TestMyBartisSpring {

	@Autowired
	private StudentService studentService;
	
	@Test
	public void testFindAll() throws Exception {
		List<Student> list = studentService.findAll();
		
		System.out.println(studentService);
		System.out.println(list);
	}
}