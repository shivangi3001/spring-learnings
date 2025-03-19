package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Student;

public class PreInstantiation_SingletonBean_Test {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
          
	    context.getBean("amazon");
		


	}

}
