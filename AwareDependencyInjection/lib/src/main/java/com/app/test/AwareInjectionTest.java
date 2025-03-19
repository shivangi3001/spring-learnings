package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.beans.Vehicle;

public class AwareInjectionTest {
	
	public static void main(String[] args) {
	
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Vehicle vehicle = context.getBean("vehicle", Vehicle.class);
		System.out.println(vehicle);
		vehicle.horn();
		vehicle.musicSystem();
		
		vehicle.journey();
		 
	}

}
