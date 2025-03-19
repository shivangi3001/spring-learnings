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
public class ConsumerRunner6_Delete implements CommandLineRunner {
	
	private static final String GET_ALL_STUDENT_URL="/student/delete-student/{id}";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${provider.base.url}")
	private String baseUrl;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRunner6_Delete.class);

	@Override
	public void run(String... args) throws Exception {
		
		String uri = new StringBuffer()
								.append(baseUrl)
								.append(GET_ALL_STUDENT_URL)
								.toString();
		
		
		//make http call using the delete method
		restTemplate.delete(uri,1001);
		
		LOGGER.info("Student Deleted Successfully!");
	
	}

}
