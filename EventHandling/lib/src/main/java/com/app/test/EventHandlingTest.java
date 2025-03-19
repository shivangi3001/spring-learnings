package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventHandlingTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		((AbstractApplicationContext)context).close();
		
		
	}

}
