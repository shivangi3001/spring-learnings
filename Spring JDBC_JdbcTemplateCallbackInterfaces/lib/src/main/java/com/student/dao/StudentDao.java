package com.student.dao;

import java.util.List;

import com.student.entity.StudentEntity;

public interface StudentDao {
	
    public StudentEntity getStudentById(int id) throws Exception;
    
    public List<StudentEntity> getStudentListByCourse(
    						    String course1, 
    						    String course2, 
    						    String course3
    						    ) throws Exception;
}
