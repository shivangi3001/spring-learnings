package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.BankService;

public class AspectJAOP_AroundAdvice_Test {
	
	public static void main(String[] args) {
		ApplicationContext context  =  null;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		BankService bankService = context.getBean("bs", BankService.class);
		
		System.out.println(bankService.calSi(1200, 2, 2));
		System.out.println("-------------------------------");
		System.out.println(bankService.calCi(1200, 2, 2));
		
		
		((AbstractApplicationContext)context).close();
	}

}
