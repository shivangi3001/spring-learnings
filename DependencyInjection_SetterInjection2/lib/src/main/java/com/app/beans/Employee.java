package com.app.beans;

import java.util.Date;

//target class
public class Employee {
	
	private String empName;
	
	//Date :: dependent class here...
	private Date empDob;
	private String dept;
	
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empDob=" + empDob + ", dept=" + dept + "]";
	}
	
	
	
	

}
