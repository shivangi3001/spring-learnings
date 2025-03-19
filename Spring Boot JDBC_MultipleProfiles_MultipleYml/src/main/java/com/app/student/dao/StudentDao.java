package com.app.student.dao;

import java.util.List;

import com.app.student.entity.StudentEntity;



public interface StudentDao {
	
  // public String getStudentName(int id) throws Exception;
  // public List<StudentEntity> getStudentDetailsByCourse(String course1, String course2, String course3) throws Exception;
   public int registerStudent(StudentEntity entity) throws Exception; 
   
}
