package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Amazon;
import com.app.beans.Employee;

public class JavaConfigAnnotationTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Employee emp = context.getBean(Employee.class);
//		System.out.println(emp);
		
		
		Amazon amazon = context.getBean("myamazon",Amazon.class);
		System.out.println(amazon);
	}

}
