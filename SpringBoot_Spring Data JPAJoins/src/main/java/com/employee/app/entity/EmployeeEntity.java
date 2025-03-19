package com.employee.app.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_table")
public class EmployeeEntity  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eid;
	
	@Column(name = "ename")
	private String name;
	
	private String email;
	
	@Column
	private Float salary;
	
	private String city;
	

	@ManyToOne(targetEntity = DepartmentEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id", referencedColumnName = "deptId")
	private DepartmentEntity dept;
	
	public EmployeeEntity() {
		
	}
	
	

	public EmployeeEntity( String name, String email, Float salary, String city) {
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.city = city;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [eid=" + eid + ", name=" + name + ", email=" + email + ", salary=" + salary + ", city="
				+ city + ", dept=" + dept + "]";
	}

	public DepartmentEntity getDept() {
		return dept;
	}

	public void setDept(DepartmentEntity dept) {
		this.dept = dept;
	}

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

	

	  


}
