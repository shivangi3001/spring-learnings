package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Employee;

public class SetterInjection_Test3 {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("com/app/config/applicationContext.xml");
		
		Employee emp = (Employee) context.getBean("emp");
		System.out.println(emp);
				
	}

}
