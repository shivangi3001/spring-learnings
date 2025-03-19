package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.ShoppingStore;

public class AspectJAOP_ThrowsAdviceTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ShoppingStore store = context.getBean("store", ShoppingStore.class);
		
		String[] items = {"shoes", "t-shirt", "lower"};
	    float[] prices = {1000.00f, 200.00f, 0.0f};
		float bill = store.generateBill(items, prices);
		
		System.out.println(bill);
	}

}
