package com.app.student.service;

import com.app.student.dao.StudentDao;
import com.app.student.dto.StudentDto;
import com.app.student.entity.StudentEntity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public final class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	

	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	@Override
	public int registerNewStudent(StudentDto dto) throws Exception {
		StudentEntity entity = null;
		String grade = null;
		
		//converting dto to entity
		entity = new StudentEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCourseName(dto.getCourseName());
		entity.setObtMarks(dto.getObtMarks());
		
		//calculate gradle
		if(dto.getObtMarks() >= 400) {
			grade = "A";
		}
		else if(dto.getObtMarks() >= 350) {
			grade="B";
		}
		else if(dto.getObtMarks() >= 300) {
		    grade="C";
		}
		else if(dto.getObtMarks() >= 200) {
			grade="D";
		}
		else {
			grade="Fail";
		}
		
		dto.setGrade(grade);
		entity.setGrade(dto.getGrade());
		int i = studentDao.saveStudent(entity);
		return i;
		
	}
	
	
	
	@PostConstruct
	public void init() {
		System.out.println("StudentServiceImpl.init()");
		if(studentDao==null) {
			throw new IllegalArgumentException("dao cannot be null");
		}
	}

	@PreDestroy
	public void destroy() {
		System.out.println("StudentServiceImpl.destroy()");
		studentDao = null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
