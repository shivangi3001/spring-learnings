package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Student;

public class SetterInjection_Test2 {
	
	public static void main(String[] args) {
		//ioc container
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("com/app/config/applicationContext.xml");
		
		Student student = (Student)context.getBean("student");
		student.startMyCourse();
	}

}
