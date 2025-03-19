package com.app.student.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.student.entity.StudentEntity;

@Profile({"dev", "test"})
@Repository("mysqlDao")
public class MySqlStudentDaoImpl implements StudentDao {

	//mysql query
	private static final String INSERT_STUDENT = "INSERT INTO student_details(id,name,email,course_name,obtained_marks,grade) values(?,?,?,?,?,?)"; 
	
	
	public MySqlStudentDaoImpl() {
		System.out.println("MySqlStudentDaoImpl.MySqlStudentDaoImpl()");
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public int registerStudent(StudentEntity entity) throws Exception {
		int rowCount = jdbcTemplate.update(
				INSERT_STUDENT,
				entity.getId(),
				entity.getName(),
				entity.getEmail(),
				entity.getCourse_name(),
				entity.getObtained_marks(),
				entity.getGrade()
				
				);
		return rowCount;
	}

}
