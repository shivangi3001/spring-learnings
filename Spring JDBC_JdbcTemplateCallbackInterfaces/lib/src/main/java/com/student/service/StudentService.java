package com.student.service;

import java.util.List;

import com.student.dto.StudentDto;

public interface StudentService {
	
	public StudentDto getStudentDetailsById(int id) throws Exception;
	public List<StudentDto> getStudentsListByCourse(String course1, String course2, String course3) throws Exception;
	

}
