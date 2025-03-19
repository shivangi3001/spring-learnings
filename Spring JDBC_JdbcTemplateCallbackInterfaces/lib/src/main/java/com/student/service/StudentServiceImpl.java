package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.dto.StudentDto;
import com.student.entity.StudentEntity;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	@Qualifier("studentDao3")
	private StudentDao studentDao;

	@Override
	public StudentDto getStudentDetailsById(int id) throws Exception {
		StudentDto dto = null;
		dto = new StudentDto();
		
		StudentEntity entity = studentDao.getStudentById(id);
		
		//convert entity to dto
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setCourseName(entity.getCourse_name());
		dto.setObtainedMarks(entity.getObtained_marks());
		dto.setGrade(entity.getGrade());
		
		return dto;
		
	}

	@Override
	public List<StudentDto> getStudentsListByCourse(String course1, String course2, String course3) throws Exception {
		List<StudentEntity> studentEntityList = studentDao.getStudentListByCourse(course1, course2, course3);
		List<StudentDto> dtoList = new ArrayList<StudentDto>();
		for(StudentEntity entity : studentEntityList) {
			StudentDto dto = new StudentDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setEmail(entity.getEmail());
			dto.setCourseName(entity.getCourse_name());
			dto.setObtainedMarks(entity.getObtained_marks());
			dto.setGrade(entity.getGrade());
			
			dtoList.add(dto);
		}
		
		
		return dtoList;
	}

}
