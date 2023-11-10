package com.project.sm.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.sm.DAO.*;
import com.project.sm.api.Student;
import com.project.sm.service.StudentService;

@Controller
public class StudentController {
	
 
	@Autowired
private StudentService studentService;
@GetMapping("/showStudent")

public String showStudentList(Model model) {
	List <Student> studentList = studentService.loadStudents();
	
	model.addAttribute("Students", studentList);
	return "student-list";
}
@GetMapping("/addStudentPage")

public String addStudent(Model model) {
	Student StudentDTO = new Student();
	model.addAttribute("student", StudentDTO);
	return "add-student";
}

@PostMapping("/save-student")

public String saveStudent(Student Student) {
	if(Student.getId()==0) {
	studentService.saveStudent(Student);
	}
	else {
		studentService.update(Student);
	}
	return "redirect:/showStudent";
}
@GetMapping("/updateStudent")

public String updateStudent(@RequestParam("userid")int id,Model model) {
	//Student student = new Student();
	
	Student myStudent = studentService.getStudent(id);
	
	model.addAttribute("student", myStudent);
	
	return "add-student";
}

@GetMapping("/deleteStudent")

public String deleteStudent(@RequestParam("userid") int id) {
	studentService.deleteStudent(id);
	return "redirect:/showStudent";
}
}