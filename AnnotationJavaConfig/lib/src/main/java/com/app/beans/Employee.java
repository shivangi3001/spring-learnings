package com.app.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.inject.Named;

@Named
public class Employee {

	@Value("Amit")
	private String name;
	
	@Value("${emp.desgn}")
	private String designation;

	@Override
	public String toString() {
		return "Employee [name=" + name + ", designation=" + designation + "]";
	}
	
	
	
	
}
