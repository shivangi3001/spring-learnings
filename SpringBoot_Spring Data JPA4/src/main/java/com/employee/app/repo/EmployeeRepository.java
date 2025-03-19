package com.employee.app.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.app.entity.EmployeeEntity;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>  {
   
	//finder methods - select operations
	
	public List<EmployeeEntity> findBySalary(Float salary);
	public List<EmployeeEntity> findByName(String name);
	
	
	//finding employee list whose salary is less than 20000
	public List<EmployeeEntity>  findBySalaryLessThanEqual(Float salary);
	
	public List<EmployeeEntity> findBySalaryGreaterThanEqual(Float salary);
	
	public List<EmployeeEntity> findByNameContaining(String chars);
	
	public List<EmployeeEntity> findByNameIgnoreCase(String name);
	
	public Iterable<EmployeeEntity> findBySalaryOrderByNameDesc(Float salary);
	
	
	//finder method using multiple properties
	public List<EmployeeEntity> findByNameAndCity(String name, String city);
	
	public List<EmployeeEntity> findByCityAndSalary(String city, Float salary);
	
	
	public List<EmployeeEntity> findBySalaryGreaterThanEqualAndNameContainingOrCity(Float salary, 
			String chars, 
			String city);
	
	//prem, rajesh, priya or city - delhi,patna
	//multiple name- multiple string data---> List:Collection
	public List<EmployeeEntity> findByNameInOrCityIn(Collection<String> names, 
													Collection<String> cities);
}

