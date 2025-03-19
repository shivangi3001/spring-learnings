package com.app.service;

import com.app.dao.StudentDao;
import com.app.dto.StudentDto;
import com.app.entity.StudentEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentDao studentDao;


    @Override
    public List<StudentDto> getAllStudentList() {
        List<StudentEntity> entityList = studentDao.getAllStudents();

        List<StudentDto> dtoList = new ArrayList<>();

        entityList.forEach(entity->{
            StudentDto dto = new StudentDto();
            BeanUtils.copyProperties(entity, dto);
            dtoList.add(dto);
        });

        return  dtoList;

    }
}
