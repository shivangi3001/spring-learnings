package com.employee.app.dto;

public class EmployeeDto {
	
  private Integer eid;
  private String name;
  private String email;
  private Float salary;
  
  
  public  EmployeeDto() {}
  
  public EmployeeDto(Integer eid) {
	  this.eid=eid;
  }
  
public EmployeeDto(Integer eid, String name, String email, Float salary) {
	this.eid = eid;
	this.name = name;
	this.email = email;
	this.salary = salary;
}
  
public Integer getEid() {
	return eid;
}
public void setEid(Integer eid) {
	this.eid = eid;
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
public Float getSalary() {
	return salary;
}
public void setSalary(Float salary) {
	this.salary = salary;
}

@Override
public String toString() {
	return "EmployeeDto [eid=" + eid + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
}
  


  
}
