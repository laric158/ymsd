package cn.itsource.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itsource.cms.dao.StudentMapper;
import cn.itsource.cms.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	public List<Student> findAll() {
		return studentMapper.findAll();
	}
}