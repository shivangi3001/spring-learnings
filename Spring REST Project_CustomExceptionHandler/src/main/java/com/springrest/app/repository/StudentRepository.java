package com.springrest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.app.entity.StudentEntity;

@Repository
public interface StudentRepository  extends JpaRepository<StudentEntity, Integer>{

}
