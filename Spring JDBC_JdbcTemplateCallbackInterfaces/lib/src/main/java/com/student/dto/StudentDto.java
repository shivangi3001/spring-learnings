package com.student.dto;

import java.io.Serializable;

public class StudentDto implements Serializable {
	
	private Integer id;
	private String name;
	private String email;
	private Integer obtainedMarks;
	private String grade;
	private String courseName;
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
	public Integer getObtainedMarks() {
		return obtainedMarks;
	}
	public void setObtainedMarks(Integer obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", email=" + email + ", obtainedMarks=" + obtainedMarks
				+ ", grade=" + grade + ", courseName=" + courseName + "]";
	}
	
	
	
	

}
