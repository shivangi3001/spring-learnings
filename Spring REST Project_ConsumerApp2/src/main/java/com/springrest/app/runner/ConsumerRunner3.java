package com.springrest.app.runner;

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
public class ConsumerRunner3 implements CommandLineRunner {
	
	private static final String GET_STUDENT_URL="/student/get-student/{id}";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${provider.base.url}")
	private String baseUrl;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRunner3.class);

	@Override
	public void run(String... args) throws Exception {
		
		String uri = new StringBuffer()
								.append(baseUrl)
								.append(GET_STUDENT_URL)
								.toString();
		
		ResponseEntity<Student> response = restTemplate.getForEntity(uri, Student.class, 1001);
		
		Student student = response.getBody();
		System.out.println("The student data is : " + student);
		
	
		LOGGER.info("Status Code : {}" , response.getStatusCode().value() );
		LOGGER.info("Student data : {} ", response.getBody());
		
	}

}
