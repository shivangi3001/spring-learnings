package com.employee.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.employee.app.controller.EmployeeController;
import com.employee.app.dto.EmployeeDto;
import com.employee.app.repo.EmployeeRepository;

@SpringBootApplication
public class Proj66SpringBootSpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context = null;
		EmployeeController controller = null;
	
		
	context =	SpringApplication.run(Proj66SpringBootSpringDataJpa1Application.class, args);
	
	controller = context.getBean("empController", EmployeeController.class);
	
	/*
	
	controller.getAllEmployeesInSortingOrder("salary", false);

	controller.getAllEmployeesInSortingOrderByMultipleProperties(true, "salary", "eid");
	
	
	controller.getEmployeesByPageNumber(5, 3);
	
	System.out.println("------------by pagination in standalone env-------------");
	controller.fetchEmployeeDataByPagination(3);
	
	System.out.println("----------------");
	controller.getEmployeeById(1020);
	
	*/
	
//	
//	controller.deleteEmployeesInBatch(List.of(
//			 new EmployeeDto(1001),
//			 new EmployeeDto(1002),
//			 new EmployeeDto(1003),
//			 new EmployeeDto(1020)
//			));
	
	
/*
	System.out.println("----------------------------");
	EmployeeDto empDto = new EmployeeDto(null, "Priya Raj", null, null, null );
	 controller.fetchEmployeesExampleData(empDto, "name", true);
	 
	 controller.getEmployeesBySalary(10000.00f);
	 
	 controller.getEmployeesByName("Prem Raj");
	 
	 System.out.println("--------------------------");
	 
	 controller.getEmployeesSalaryLessThanOrEqual(20000.00f);
	 controller.getEmployeesSalaryGreaterThanOrEqual(50000.00f);
	 controller.getEmployeesNameContainingLetters("Kumar");
	 controller.getEmployeesNameIgnoringCase("Prem raj");
	 controller.getEmployeesBySalaryOrderByNameDesc(10000.00f);
	 
	 EmployeeRepository proxyRepository = context.getBean(EmployeeRepository.class);
	 System.out.println("proxy class name of the repository interface : " +  proxyRepository.getClass());
	
	 
	 System.out.println("----------finder methods using multiple properties-----------");
	 
	 controller.getEmployeesByCityAndSalary("Delhi", 10000.00f);
	 controller.getEmployeesByNameAndCity("Prem Raj", "Delhi");
	 controller.getEmployeesBySalaryGreaterThanEqualNameContaingOrCity(10000.00f, "Raj", "Delhi");
	 controller.getEmployeesByNamesAndCities(List.of("prem raj", "Khushi Soni", "Amit Raj"), List.of("delhi", "patna", "kolkata"));
	*/
	
	
	
	controller.findEmployeeDataByCities(List.of("patna", "delhi", "kolkata"));
	
	
	
	
	}
	
	
	

}
