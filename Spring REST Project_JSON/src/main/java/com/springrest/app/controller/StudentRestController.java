package com.springrest.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.app.entity.Address;
import com.springrest.app.entity.StudentEntity;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@GetMapping("/greet-msg")
	public String greetMsg() {
		return "HELLO ANKIT!";
	}
	
	
	@GetMapping(value = "/get-student")
	public StudentEntity getStudent() {
		return new StudentEntity(1001, "Amit Kumar", "springboot", 
								new Address("Bazar Samiti", "Patna", "800001"));
	}
	
	/*
	@GetMapping("/get-course-module")
	public List<String> courseModules(){
		return Arrays.asList("spring core", 
							 "spring mvc", 
							 "spring boot rest", 
							 "microservices");
	}
	*/
	
	@GetMapping("/get-course-module")
	public Set<String> courseModules(){
		return Set.of("spring core", 
				 "spring mvc", 
				 "spring boot rest", 
				 "microservices");
	}
	
	

	@GetMapping("/get-all-students")
	public List<StudentEntity> getAllStudents() {
		return Arrays.asList(
				new StudentEntity(1001, "Amit Kumar", "springboot",new Address("Bazar Samiti", "Patna", "800001")),
				new StudentEntity(1002, "Manoj Raj", "springboot", new Address("Laxmi Nagar", "Delhi", "400001")),
				new StudentEntity(1003, "Priyam Jais", "java", new Address("Bandra Road", "Mumbai", "400035")),
				new StudentEntity(1001, "Anirudh Kumar", "springboot", new Address("MG Road", "Aurangabad", "834101"))
				);
	}
	
	
	
	@GetMapping("/get-marks")
	public Map<String, Integer> getStudentMarks() {
		return Map.of("java",87, "c++",89, "python",80, "js",90);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
