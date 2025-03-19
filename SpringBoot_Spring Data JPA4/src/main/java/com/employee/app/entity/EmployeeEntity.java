package com.employee.app.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_details")
public class EmployeeEntity  implements Serializable{
	
	@Id
	private Integer eid;
	
	@Column(name = "ename")
	private String name;
	
	private String email;
	
	@Column
	private Float salary;
	
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
		return "EmployeeEntity [eid=" + eid + ", name=" + name + ", email=" + email + ", salary=" + salary + ", city="
				+ city + "]";
	}
	
	

	  


}
