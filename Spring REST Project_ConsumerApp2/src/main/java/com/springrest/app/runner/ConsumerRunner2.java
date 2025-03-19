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
public class ConsumerRunner2 implements CommandLineRunner {
	
	private static final String GET_STUDENT_URL="/student/get-student/{id}";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${provider.base.url}")
	private String baseUrl;

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRunner2.class);

	@Override
	public void run(String... args) throws Exception {
		
		String uri = new StringBuffer()
								.append(baseUrl)
								.append(GET_STUDENT_URL)
								.toString();
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class, 1001);
		
		String jsonData = response.getBody();
		
		//converting json data to java object
		
		try {
			Student student = new ObjectMapper().readValue(jsonData, Student.class);
			LOGGER.info("Object data is {} ", student);
			//now you are ready to use this student object in your cosumer project
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		LOGGER.info("Status Code : {}" , response.getStatusCode().value() );
		LOGGER.info("Student data : {} ", response.getBody());
		
	}

}
