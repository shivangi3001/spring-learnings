package com.springrest.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springrest.app.response.ErrorResponseData;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 // Below methods will be called FrontController depending upon the
	 // exception thrown
	
	//here we will create custom exception handler methods
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponseData> 
			handleStudentNotFoundException(StudentNotFoundException ex)
	  {
	
		ErrorResponseData errorResponseData
		 			= new ErrorResponseData("error", ex.getMessage(), new Date().toString());
		
            ResponseEntity<ErrorResponseData> errorResponse
            	= new ResponseEntity<ErrorResponseData>(errorResponseData, HttpStatus.NOT_FOUND);
	
            return errorResponse;
	  }
	
	//here you will have to create other exception handler methods too 
	
}
	
	
	
