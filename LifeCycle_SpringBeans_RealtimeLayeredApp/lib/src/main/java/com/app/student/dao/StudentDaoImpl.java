package com.app.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.app.student.entity.StudentEntity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public final class StudentDaoImpl implements StudentDao {
	
	private final static String INSERT_STUDENT = 
			"INSERT INTO student_details(id, name, email, course_name, obtained_marks, grade) values (?,?,?,?,?,?)";

	private DataSource dataSource;
	
	
	public StudentDaoImpl(DataSource dataSource) {
		System.out.println(dataSource.getClass().getName());
		this.dataSource=dataSource;
	}
	
	
	@Override
	public int saveStudent(StudentEntity entity) throws Exception {
		//save the student to the database table
		Connection con = null;
		PreparedStatement pstmt = null;
		con = dataSource.getConnection();
		
		pstmt = con.prepareStatement(INSERT_STUDENT);
		
		pstmt.setInt(1, entity.getId());
		pstmt.setString(2, entity.getName());
		pstmt.setString(3, entity.getEmail());
		pstmt.setString(4, entity.getCourseName());
		pstmt.setInt(5, entity.getObtMarks());
		pstmt.setString(6, entity.getGrade());
		
		int i = pstmt.executeUpdate();
		return i;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("StudentDaoImpl.init()");
		if(dataSource==null) {
			throw new IllegalArgumentException("datasource cannot be null");
		}
	}

	@PreDestroy
	public void destroy() {
		System.out.println("StudentDaoImpl.destroy()");
		dataSource = null;
	}
}
