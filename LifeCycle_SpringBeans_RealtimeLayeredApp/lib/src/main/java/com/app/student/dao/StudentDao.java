package com.app.student.dao;

import com.app.student.entity.StudentEntity;

public interface StudentDao {
	
	public int saveStudent(StudentEntity entity) throws Exception;

}
