package com.app.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vehicle implements ApplicationContextAware{
	

	private String dependentBeanId;
	private ApplicationContext context;
	
	public void setDependentBeanId(String dependentBeanId) {
		this.dependentBeanId=dependentBeanId;
	}
	
	
	

	public void musicSystem() {
		System.out.println("music system turned on");
	}
	
	public void horn() {
		System.out.println("hornn blownn");
	}
	
	public void headlight() {
		System.out.println("headlight turned on...");
	}
	
	
	public void journey() {
		

		Engine engine = context.getBean(dependentBeanId, Engine.class);
		//here only engine is required...
	   engine.startEngine();
	   System.out.println("journed continued...and reached to the destination");
	   engine.stopEngine();
	}




	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context=applicationContext;
		
	}

}
