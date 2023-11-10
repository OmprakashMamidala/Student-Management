package com.project.sm.DAO;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.sm.api.Student;
import com.project.sm.rowmapper.*;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
  private JdbcTemplate jdbcTemplate ;
	@Override
	public List<Student> loadStudents() {
		
		String sql = "SELECT * FROM students";
	   List<Student>theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());
	   
		return theListOfStudent;
	}
	@Override
	public void saveStudent(Student student) {
		Object[] sqlParameters = {student.getName(),student.getMobile(),student.getCountry()};
		String sql = "INSERT INTO STUDENTS(name,mobile,country)values (?,?,?)";
		jdbcTemplate.update(sql, sqlParameters);
		System.out.println("record updated..");
		
	}
	@Override
	public Student getStudent(int id) {
		String sql = "select * from students where id=?";
		Student student = jdbcTemplate.queryForObject(sql,new StudentRowMapper(),id );
		return student;
	}
	@Override
	public void update(Student student) {
		String sql = "UPDATE STUDENTS SET name=? ,mobile=?,country=? WHERE ID=?";
		jdbcTemplate.update(sql, student.getName(),student.getMobile(),student.getCountry(),student.getId());
	}
	@Override
	public void delete(int id) {// TODO Auto-generated method stub
		String sql = "DELETE FROM STUDENTS WHERE ID=?";
		jdbcTemplate.update(sql, id);
	}
	
	

}
