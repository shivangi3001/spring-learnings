package com.app.student.dto;

import java.io.Serializable;

public class StudentDto implements Serializable{
	
	private Integer id;
	private String name;
	private String email;
	private String courseName;
	private Integer obtMarks;
	private String grade;
	
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getObtMarks() {
		return obtMarks;
	}
	public void setObtMarks(Integer obtMarks) {
		this.obtMarks = obtMarks;
	}

}
