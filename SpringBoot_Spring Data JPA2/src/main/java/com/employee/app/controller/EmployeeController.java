package com.employee.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.service.EmployeeService;

@Controller("empController")
public class EmployeeController {
	
    @Autowired
	private EmployeeService empService;
    
    
    public void getAllEmployeesInSortingOrder(String property, boolean ascendingOrder) {
    	List<EmployeeDto> dtoList = empService.getAllEmployees(property, ascendingOrder);
        System.out.println(dtoList);
    }
    
    
    public void getAllEmployeesInSortingOrderByMultipleProperties(boolean ascendingOrder, String...properties) {
    	List<EmployeeDto> dtoList = empService.getAllEmployees(ascendingOrder, properties);
        System.out.println(dtoList);
    }
    
    
    public void getEmployeesByPageNumber(int pageSize, int pageNo) {
    	List<EmployeeDto> dtoList = empService.getPageRecords(pageNo, pageSize);
    	System.out.println(dtoList);
    }
    
    
    
    
    
}
