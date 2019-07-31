package cn.itsource.cms.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.itsource.cms.model.Student;

@Component
public interface StudentMapper {


	/**
	 * 查询所有的
	 * @return
	 */
	List<Student> findAll();
	
	/**
	 * 根据ID查询单个
	 * @param id
	 * @return
	 */
	Student findById(int id);
}