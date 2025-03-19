package com.app.beans;

//target class
public class Student {
	
	private String name;
	private String username;
	private String email;
	private Course course;
	
	public Student() {
		System.out.println("Student.Student()");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public void setCourse(Course course) {
		System.out.println(course.hashCode());
		System.out.println("setcourse is called");
		this.course = course;
	}
	
//	public void setAnkit(Course course) {
//		System.out.println(course.hashCode());
//		System.out.println("setankit is called");
//		this.course=course;
//	}
	
	
	public void startMyCourse() {
		
		String msg = "Hello " + name + "  |  " + username;
		
		System.out.println(msg);
		//dependent class object is being used here...
		course.startCourse();
	}
	
	

}
