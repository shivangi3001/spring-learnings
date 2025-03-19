package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.WebContainer;

public class LookupMethodInjection_Test {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		WebContainer container = context.getBean("webContainer", WebContainer.class);
		
		container.processRequest("xyz  data....");
		container.processRequest("abc  data....");
		
		System.out.println(container.getClass().getName());
	}

}
