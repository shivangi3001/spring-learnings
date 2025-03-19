package com.employee.app.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.employee.app.dto.EmployeeDto;
import com.employee.app.repo.ResultView;
import com.employee.app.service.EmployeeService;

@Controller("empController")
public class EmployeeController {
	
    @Autowired
    @Qualifier("empService2")
	private EmployeeService empService;
    /*
    
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
    
    
    public void fetchEmployeeDataByPagination(int pageSize) {
    	empService.getRecordsByPagination(pageSize);
    }
    
    public void getEmployeeById(int eid) {
    	System.out.println(empService.fetchEmployeeById(eid));
    }
    
    
    public void deleteEmployeesInBatch(List<EmployeeDto> dtoList) {
    	empService.removeEmployeesInBatch(dtoList);
    	System.out.println("Employee batch deleted...");
    }
    
    public void fetchEmployeesExampleData(EmployeeDto dto, String property, boolean ascendingOrder) {
    	List<EmployeeDto> dtos = empService.fetchEmployeesBySomeData(dto, property, ascendingOrder);
         System.out.println(dtos);
    }
    
    public void getEmployeesBySalary(Float salary) {
    	System.out.println(empService.getEmployeesBySalary(salary));
    }
    
    public void getEmployeesByName(String name) {
    	System.out.println(empService.getEmployeesByName(name));
    }
    
    
    public void getEmployeesSalaryLessThanOrEqual(Float salary) {
    	System.out.println("EmployeeController.getEmployeesSalaryLessThanOrEqual()");
    	System.out.println(empService.getEmployeesBySalaryLessThanOrEqual(salary));
    }

    public void getEmployeesSalaryGreaterThanOrEqual(Float salary) {
    	System.out.println("EmployeeController.getEmployeesSalaryGreaterThanOrEqual()");
    	System.out.println(empService.getEmployeesBySalaryGreaterThanOrEqual(salary));
    }
    
    public void getEmployeesNameContainingLetters(String chars) {
    	System.out.println("EmployeeController.getEmployeesNameContainingLetters()");
    	System.out.println(empService.getEmployeesThatContainsInName(chars));
    }
    
    public void getEmployeesNameIgnoringCase(String name) {
    	System.out.println("EmployeeController.getEmployeesNameIgnoringCase()");
    	System.out.println(empService.getEmployeesByNameIgnoringCase(name));
    }
    
    public void getEmployeesBySalaryOrderByNameDesc(Float salary) {
    	System.out.println("EmployeeController.getEmployeesBySalaryOrderByNameDesc()");
    	System.out.println(empService.getEmployeesBySalaryOrderByNameDesc(salary));
    }
    
    public void getEmployeesByCityAndSalary(String city, Float salary) {
    	System.out.println("EmployeeController.getEmployeesByCityAndSalary()");
    	System.out.println(empService.getEmployeesByCityAndSalary(city, salary));
    }
    
    public void getEmployeesByNameAndCity(String name, String city) {
    	System.out.println("EmployeeController.getEmployeesByNameCity()");
    	System.out.println(empService.getEmployeesByNameAndCity(name, city));
    }
    
    public void getEmployeesBySalaryGreaterThanEqualNameContaingOrCity(Float salary, String chars, String city) {
    	System.out.println("EmployeeController.getEmployeesBySalaryGreaterThanEqualNameContaingOrCity()");
    	System.out.println(empService.getEmployeesBySalaryGreaterThanEqualAndNameContainingOrCity(salary, chars, city));
    }
    
    public void getEmployeesByNamesAndCities(Collection<String> names, Collection<String> cities) {
    	System.out.println("EmployeeController.getEmployeesByNamesAndCities()");
    	System.out.println(empService.getEmployeesByNamesAndCities(names, cities));
    }
    
    
    
    
    
    */
    
    public void findEmployeeDataByCities(Collection<String> cities) {
    	List<ResultView> resultList = empService.getEmployeesDataByCities(cities);
        
    	resultList.forEach(viewData->{
    		System.out.println(viewData.getEid() + "   " + viewData.getName());
    	});
    
    }
    
    
    
    
}
