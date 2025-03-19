package com.app.beans;

//dependent class
public class Course {
	
	private String courseName;
	
	
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Course() {
		System.out.println("Course.Course()");
	}
	
   
	public void startCourse() {
		System.out.println("Your course : " + courseName + " is loading...");
	}
	
	
}
