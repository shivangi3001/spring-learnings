package com.springrest.app.exception;

public class StudentNotFoundException extends RuntimeException {
	
	public StudentNotFoundException () {
		
	}
	
	public StudentNotFoundException(String message) {
		super(message);
	}

}
