package com.employee.app.entity;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department_table")
public class DepartmentEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptId;
	
	@Column(name = "dept_name")
	private String name;
	
	@Column(name = "location")
	private String deptLocation;
	
	
	@OneToMany(targetEntity = EmployeeEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dept")
	@LazyCollection(LazyCollectionOption.TRUE) // deprecated from 6.2 version of hibernate
	private Set<EmployeeEntity> employees;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	public Set<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeEntity> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", name=" + name + ", deptLocation=" + deptLocation
				+ ", employees=" + employees + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
