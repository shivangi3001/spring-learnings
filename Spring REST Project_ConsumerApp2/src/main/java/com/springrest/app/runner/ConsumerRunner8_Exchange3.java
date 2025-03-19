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
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.app.model.Student;


@Component
public class ConsumerRunner8_Exchange3 implements CommandLineRunner {
	
	private static final String REGISTER_STUDENT_URL="/student/register-student";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${provider.base.url}")
	private String baseUrl;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRunner8_Exchange3.class);

	@Override
	public void run(String... args) throws Exception {
		
		String url = new StringBuffer()
								.append(baseUrl)
								.append(REGISTER_STUDENT_URL)
								.toString();
		
		
		//create header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//request body
		Student student = new Student(9001, "Amit Kumar Ranjan", "amitranj@gmail.com", "spring boot", "A+", 1000.0);
		
		//prepare the request
		HttpEntity<Student> request = new HttpEntity<Student>(student, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
		
		LOGGER.info("Status code : {} ",  response.getStatusCode().value());
		LOGGER.info("Data: {}",  response.getBody());
		
	
	}

}
