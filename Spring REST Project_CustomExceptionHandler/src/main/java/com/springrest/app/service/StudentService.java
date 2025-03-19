package com.springrest.app.service;

import java.util.List;

import com.springrest.app.entity.StudentEntity;

public interface StudentService {
	
	public String registerNewStudent(StudentEntity entity);
	public List<StudentEntity> getAllStudents();
	public StudentEntity getStudentById(Integer id);
	public String deleteStudentById(Integer id);
	public String updateStudent(Integer id, StudentEntity entity);

}
