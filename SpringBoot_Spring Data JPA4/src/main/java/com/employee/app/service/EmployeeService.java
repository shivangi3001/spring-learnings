package com.employee.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.repo.EmployeeRepo;
import com.employee.app.repo.ResultView;

public interface EmployeeService {

	/*
	public List<EmployeeDto> getAllEmployees(String property, boolean ascendingOrder);
	
	public List<EmployeeDto> getAllEmployees(boolean ascendingOrder, String... properties);
	
	public List<EmployeeDto> getPageRecords(int pageNo, int pageSize);
	
	public void getRecordsByPagination(int pageSize);
	
	
	public EmployeeDto  fetchEmployeeById(int eid);
	
	public  void  removeEmployeesInBatch(List<EmployeeDto> listDto);
	
	
	public List<EmployeeDto> fetchEmployeesBySomeData(EmployeeDto dto, String property, boolean ascendingOrder );
	
	public List<EmployeeDto> getEmployeesBySalary(Float salary);
	
	public List<EmployeeDto> getEmployeesByName(String name);
	
	
	public List<EmployeeDto> getEmployeesBySalaryLessThanOrEqual(Float salary);
	public List<EmployeeDto> getEmployeesBySalaryGreaterThanOrEqual(Float salary);
	public List<EmployeeDto> getEmployeesThatContainsInName(String chars);
	public List<EmployeeDto> getEmployeesByNameIgnoringCase(String name);
	public List<EmployeeDto> getEmployeesBySalaryOrderByNameDesc(Float salary);
	
	
	public List<EmployeeDto> getEmployeesByNameAndCity(String name, String city);
	public List<EmployeeDto> getEmployeesByCityAndSalary(String city, Float salary);
	public List<EmployeeDto> getEmployeesBySalaryGreaterThanEqualAndNameContainingOrCity(Float salary, String chars, String city);
	public List<EmployeeDto> getEmployeesByNamesAndCities(Collection<String> names, Collection<String> cities);
	
	*/
	
	
	public List<ResultView> getEmployeesDataByCities(Collection<String> cities);
	
	
	
	
	
	
	
	
	
	
}
