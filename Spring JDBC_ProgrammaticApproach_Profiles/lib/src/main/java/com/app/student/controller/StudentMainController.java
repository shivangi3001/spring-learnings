package com.app.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.student.dto.StudentDto;
import com.app.student.service.StudentService;


@Controller("controller")
public class StudentMainController {
	
	
	@Autowired
	private StudentService studentService;

	
	
	public int processNewStudentRegistration(StudentDto dto) throws Exception {
		return studentService.registerNewStudent(dto);	
	}
}
