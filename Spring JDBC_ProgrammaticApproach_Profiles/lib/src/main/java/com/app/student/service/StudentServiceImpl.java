package com.app.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.student.dao.StudentDao;
import com.app.student.dto.StudentDto;
import com.app.student.entity.StudentEntity;


@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	


	@Override
	public int registerNewStudent(StudentDto dto) throws Exception {
		StudentEntity entity = null;
		entity = new StudentEntity();
		
		String grade = null;
		
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCourse_name(dto.getCourseName());
		entity.setObtained_marks(dto.getObtainedMarks());
		
		//calculate gradle
				if(dto.getObtainedMarks() >= 400) {
					grade = "A";
				}
				else if(dto.getObtainedMarks() >= 350) {
					grade="B";
				}
				else if(dto.getObtainedMarks() >= 300) {
				    grade="C";
				}
				else if(dto.getObtainedMarks() >= 200) {
					grade="D";
				}
				else {
					grade="Fail";
				}
				
				dto.setGrade(grade);
				entity.setGrade(dto.getGrade());
				
		
		int count = studentDao.registerStudent(entity);
		return count;
	}




	
	
	
	
}
