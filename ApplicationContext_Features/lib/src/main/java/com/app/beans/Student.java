package com.app.beans;

public class Student {
	
	private String name;
	
	public Student() {
		System.out.println("Student.Student()");
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void showStudentDetails() {
		System.out.println("Student name : " + name);
	}
	
	
	

}
