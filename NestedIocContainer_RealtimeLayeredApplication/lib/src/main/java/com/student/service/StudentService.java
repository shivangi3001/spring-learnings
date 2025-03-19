package com.student.service;

import java.util.List;


import com.student.dto.StudentDto;

public interface StudentService {
	
	public List<StudentDto> getAllStudentsRecords() throws Exception;

}
