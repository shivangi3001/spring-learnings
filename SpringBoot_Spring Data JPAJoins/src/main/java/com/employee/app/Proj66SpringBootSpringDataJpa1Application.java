package com.employee.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.employee.app.controller.CompanyController;
import com.employee.app.dto.EmployeeDto;


@SpringBootApplication
public class Proj66SpringBootSpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context = null;
		CompanyController controller = null;
	
		
	context =	SpringApplication.run(Proj66SpringBootSpringDataJpa1Application.class, args);
	
	controller = context.getBean("controller", CompanyController.class);
	
//	controller.saveDataUsingParent();
//	controller.saveDataUsingChild();
//	controller.getDataUsingParent();
//	controller.getDataUsingChild();
	
	controller.getJoinsDataParentToChild();
//	controller.getJoinsDataChildToParent();
	
	}
	
	
	

}
