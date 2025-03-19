package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentEntity;

@Repository("studentDao3")
public class StudentDaoImpl3 implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String GET_STUDENT_BY_ID="SELECT * FROM student_details WHERE id=?";
    private static final String GET_STUDENTS_BY_COURSE = "SELECT * FROM student_details WHERE course_name IN(?,?,?)";
	
	
	
	@Override
	public StudentEntity getStudentById(int id) throws Exception {
		
		StudentEntity studentEntity =	jdbcTemplate.queryForObject(
					GET_STUDENT_BY_ID, 
					new BeanPropertyRowMapper<StudentEntity>(StudentEntity.class),
					id);
			
			 
			 return studentEntity;
	}

	@Override
	public List<StudentEntity> getStudentListByCourse(String course1, String course2, String course3) throws Exception {
		
		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		
		
		//using lambda expression
		jdbcTemplate.query(
				GET_STUDENTS_BY_COURSE, 
				rs -> {
					
					System.out.println("StudentDaoImpl3.getStudentListByCourse() :: lambda based expression : processRow -> RowCallbackHandler");
					
					StudentEntity entity = new StudentEntity();
					entity.setId(rs.getInt(1));
					entity.setName(rs.getString(2));
					entity.setEmail(rs.getString(3));
					entity.setCourse_name(rs.getString(4));
					entity.setObtained_marks(rs.getInt(5));
					entity.setGrade(rs.getString(6));
					
				

					studentList.add(entity);
					
				},
				course1,course2,course3);
		
		
		
		/*
	   jdbcTemplate.query(
		 	     GET_STUDENTS_BY_COURSE,
		 	     //anonymous inner class implementation
			     new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						
						System.out.println("StudentDaoImpl3.StudentRowCallbackHandler.processRow()");
						
						StudentEntity entity = new StudentEntity();
						entity.setId(rs.getInt(1));
						entity.setName(rs.getString(2));
						entity.setEmail(rs.getString(3));
						entity.setCourse_name(rs.getString(4));
						entity.setObtained_marks(rs.getInt(5));
						entity.setGrade(rs.getString(6));
						
					

						studentList.add(entity);
						
					}
		 	    	 
		 	     },
			     course1,course2,course3
			   );
			   */
	   
	return studentList;
	
	
	
	}
	
	/*
	private static class StudentRowCallbackHandler implements RowCallbackHandler {

		private List<StudentEntity> studentList;
		
		public StudentRowCallbackHandler(List<StudentEntity> studentList) {
			this.studentList = studentList;
		}
		
		@Override
		public void processRow(ResultSet rs) throws SQLException {
			System.out.println("StudentDaoImpl3.StudentRowCallbackHandler.processRow()");
			
			StudentEntity entity = new StudentEntity();
			entity.setId(rs.getInt(1));
			entity.setName(rs.getString(2));
			entity.setEmail(rs.getString(3));
			entity.setCourse_name(rs.getString(4));
			entity.setObtained_marks(rs.getInt(5));
			entity.setGrade(rs.getString(6));
			
		

			studentList.add(entity);
			
			
		}
		
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
}
