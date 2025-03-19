package com.app.student.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.student.entity.StudentEntity;

@Profile({"uat", "prod"})
@Repository("psqlDao")
public class PsqlStudentDaoImpl implements StudentDao {
	
	//psql query
	private static final String INSERT_STUDENT = "INSERT INTO student_list(id,name,email,course_name,obtained_marks,grade) values(?,?,?,?,?,?)"; 
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PsqlStudentDaoImpl() {
		System.out.println("PsqlStudentDaoImpl.PsqlStudentDaoImpl()");
	}
	
	
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
