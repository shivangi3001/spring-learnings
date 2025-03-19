package com.student.dao;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentEntity;

//@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	private static final String GET_STUDENT_BY_ID="SELECT * FROM student_details WHERE id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public StudentEntity getStudentById(int id) throws Exception {
		
		
		/*
		 StudentEntity entity = jdbcTemplate.queryForObject(
				 GET_STUDENT_BY_ID, 
				 
				 new RowMapper<StudentEntity>() {

					@Override
					public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						StudentEntity entity = null;
						entity = new StudentEntity();
						
						entity.setId(rs.getInt(1));
						entity.setName(rs.getString(2));
						entity.setEmail(rs.getString(3));
						entity.setObtained_marks(rs.getInt(5));
						entity.setCourse_name(rs.getString(4));
						entity.setGrade(rs.getString(6));
						
						
						return entity;
					}
					 
					
				 }
					 , 
				 
				 id);
				 
				 */
		
		/*
	StudentEntity studentEntity =	jdbcTemplate.queryForObject(
				GET_STUDENT_BY_ID,
				(rs,rowNum)-> {
					StudentEntity entity = null;
					entity = new StudentEntity();
					
					entity.setId(rs.getInt(1));
					entity.setName(rs.getString(2));
					entity.setEmail(rs.getString(3));
					entity.setObtained_marks(rs.getInt(5));
					entity.setCourse_name(rs.getString(4));
					entity.setGrade(rs.getString(6));
					return entity;
				},
				id
				);
		
		*/
		
	StudentEntity studentEntity =	jdbcTemplate.queryForObject(
				GET_STUDENT_BY_ID, 
				new BeanPropertyRowMapper<StudentEntity>(StudentEntity.class),
				id);
		
		 
		 return studentEntity;
	}
	
	
	
	
	
	
	
	

	
	/*
	//nested
	private static class StudentMapper implements RowMapper<StudentEntity> {

		@Override
		public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentEntity entity = null;
			entity = new StudentEntity();
			
			entity.setId(rs.getInt(1));
			entity.setName(rs.getString(2));
			entity.setEmail(rs.getString(3));
			entity.setObtained_marks(rs.getInt(5));
			entity.setCourse_name(rs.getString(4));
			entity.setGrade(rs.getString(6));
			
			
			return entity;
		}
		
		*/
		
	}








