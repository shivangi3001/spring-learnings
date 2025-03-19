package com.springrest.app.runner;


import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.app.model.Student;


//@Component
public class ConsumerRunner5_Post implements CommandLineRunner {
	
	private static final String GET_ALL_STUDENT_URL="/student/register-student";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${provider.base.url}")
	private String baseUrl;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRunner5_Post.class);

	@Override
	public void run(String... args) throws Exception {
		
		String uri = new StringBuffer()
								.append(baseUrl)
								.append(GET_ALL_STUDENT_URL)
								.toString();
		
		//set the header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//requestBody
		
		//student data---> body data
		Student student = new Student(1090, "Amrit", "amrit@gmail.com", "springboot", "A+", 1000d);
		
		//json string format data
//		String jsonString = "{\"id\":1067, \"name\":\"Sheetal Jais\", \"course\":\"springboot\", \"email\":\"priyam@gmail.com\"}";

		
		//prepare http request----http request as per java object data---> this will be
		//internally converted in the json by JACKSON_API
		HttpEntity<Student> request =  new HttpEntity<Student>(student, headers);
		
		//http request as per json string format data
//		HttpEntity<String> request = new HttpEntity<String>(jsonString, headers);
		
		
		//make the http request call
		ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
		
		LOGGER.info("Status Code  {}", response.getStatusCode().value());
		LOGGER.info("Message :: {} ", response.getBody());
		
	}

}
