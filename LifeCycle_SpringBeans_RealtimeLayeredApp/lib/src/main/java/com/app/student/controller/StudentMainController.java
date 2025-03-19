package com.app.student.controller;

import com.app.student.dto.StudentDto;
import com.app.student.service.StudentService;
import com.app.student.vo.StudentVo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class StudentMainController {
	
	private StudentService studentService;
	
	public StudentMainController(StudentService studentService) {
		this.studentService=studentService;			
	}

	
	public void registerStudentRequest(StudentVo vo) throws Exception{
		
		//convert the vo to dto
		StudentDto dto = null;
		dto = new StudentDto();
		dto.setId(Integer.parseInt(vo.getId()));
		dto.setName(vo.getName());
		dto.setEmail(vo.getEmail());
		dto.setCourseName(vo.getCourseName());
		dto.setObtMarks(Integer.parseInt(vo.getObtMarks()));;
		
		int i = studentService.registerNewStudent(dto);
		
		if(i>0)
			System.out.println("record saved successfully!");
		else
			System.out.println("record not saved!");
		
		
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("StudentMainController.init()");
		if(studentService==null) {
			throw new IllegalArgumentException("studentService cannot be null");
		}
	}

	@PreDestroy
	public void destroy() {
		System.out.println("StudentMainController.destroy()");
		studentService = null;
	}
}
