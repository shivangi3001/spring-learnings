package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import com.student.dto.StudentDto;
import com.student.service.StudentService;
import com.student.vo.StudentVo;

public class StudentMainAppController {
	
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public List<StudentVo> processFetchAllStudentsRecordRequest() throws Exception{
	
		List<StudentDto> studentDtoList =  studentService.getAllStudentsRecords();
		
		List<StudentVo>  studentVoList = new ArrayList<StudentVo>();
		
		for(StudentDto studentDto : studentDtoList) {
			
			StudentVo vo = new StudentVo();
			vo.setId(studentDto.getId().toString());
			vo.setName(studentDto.getName());
			vo.setEmail(studentDto.getEmail());
			vo.setPassword(studentDto.getPassword());
			
			studentVoList.add(vo);
		}
	
		
		return studentVoList;
		
		
	}

}
