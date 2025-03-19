package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.student.dto.StudentDto;
import com.student.service.StudentService;

@Controller("controller")
public class StudentMainController {
	
	
	@Autowired
	private StudentService studentService;

	
	public StudentDto processGetStudentDetailsRequest(int id) throws Exception {
		return studentService.getStudentDetailsById(id);
	}
	
	
	public List<StudentDto> fetchStudentsList(String course1, String course2, String course3) throws Exception{
		return studentService.getStudentsListByCourse(course1, course2, course3);
	}
}
