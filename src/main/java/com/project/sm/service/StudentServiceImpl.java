package com.project.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.project.sm.api.Student;
import com.project.sm.DAO.*;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO ;

	@Override
	public List<Student> loadStudents() {
	List<Student>studentList = studentDAO.loadStudents();
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		 studentDAO.saveStudent(student);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getStudent(int id) {
		
		return studentDAO.getStudent(id);
	}

	@Override
	public void update(Student student) {
		 studentDAO.update(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		 studentDAO.delete(id);
		
	}

	

}
