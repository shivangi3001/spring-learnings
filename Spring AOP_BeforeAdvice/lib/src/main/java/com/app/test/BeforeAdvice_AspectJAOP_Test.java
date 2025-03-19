package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.LaptopShowRoom;

public class BeforeAdvice_AspectJAOP_Test {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		LaptopShowRoom showroom = context.getBean("showRoom", LaptopShowRoom.class);
		
		String result = showroom.sale("rog-series", 120000.00f, "Rajesh Verma");
		System.out.println(result);
		
		System.out.println(showroom.getClass().getName());
	}

}
