package com.springrest.app.runner;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.app.model.Student;


//@Component
public class ConsumerRunner4 implements CommandLineRunner {
	
	private static final String GET_ALL_STUDENT_URL="/student/get-all-students";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${provider.base.url}")
	private String baseUrl;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRunner4.class);

	@Override
	public void run(String... args) throws Exception {
		
		String uri = new StringBuffer()
								.append(baseUrl)
								.append(GET_ALL_STUDENT_URL)
								.toString();
		
		ResponseEntity<Student[]> response =  restTemplate.getForEntity(uri, Student[].class);
		LOGGER.info("Status Code:: {}", response.getStatusCode().value());
		
		
		
		//reading the array from the response body (response data)
		Student[] allStudents = response.getBody();
		
		//converting the array to the List
		List<Student> studentList = Arrays.asList(allStudents);
		
		LOGGER.info("Student List is :- {}" , studentList);
		
	}

}
