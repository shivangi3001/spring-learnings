package com.employee.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.repo.EmployeeRepo;

public interface EmployeeService {

	
	public List<EmployeeDto> getAllEmployees(String property, boolean ascendingOrder);
	
	public List<EmployeeDto> getAllEmployees(boolean ascendingOrder, String... properties);
	
	public List<EmployeeDto> getPageRecords(int pageNo, int pageSize);
	
	
	
	
	
}
