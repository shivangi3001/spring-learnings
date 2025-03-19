package com.app.student.service;

import java.util.List;

import com.app.student.dto.StudentDto;

public interface StudentService {
	
	 //public String getStudentName(int id) throws Exception;
	//public List<StudentDto> getStudentDetailsByCourse(String course1, String course2, String course3) throws Exception;
    public int registerNewStudent(StudentDto dto) throws Exception;
}
