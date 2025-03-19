package com.springrest.app.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.app.entity.StudentEntity;
import com.springrest.app.exception.StudentNotFoundException;
import com.springrest.app.repository.StudentRepository;
import com.springrest.app.util.StudentUtil;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public String registerNewStudent(StudentEntity entity) {
		studentRepository.save(entity);
		return "student is registered";
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity getStudentById(Integer id) {
		
		Optional<StudentEntity> entity = studentRepository.findById(id);
		 
		 if(entity.isPresent()) {
			 //if the student is present then return the student entity object
			 return entity.get();
		 }
		 else {
			 //else student is not present then throw custom exception
			 throw new StudentNotFoundException("Student Not Found With Given Id : " + id);
		 }
	}

	@Override
	public String deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
		return "student deleted successfully";
	}

	@Override
	public String updateStudent(Integer id, StudentEntity entity) {
		//first check if it exists or not
		
		//this is db entity object
		StudentEntity studentEntity = studentRepository.findById(id).get();
		
		StudentUtil.copyNonNullProperties(studentEntity, entity);
		 
		
			studentRepository.save(studentEntity);
		
		
		return "student updated successfully";
	}
	
	

}
