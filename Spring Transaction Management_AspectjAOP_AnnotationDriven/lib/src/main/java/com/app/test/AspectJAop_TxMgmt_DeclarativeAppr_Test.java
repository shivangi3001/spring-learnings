package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.BankService;

public class AspectJAop_TxMgmt_DeclarativeAppr_Test {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = null;
		
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BankService bs = context.getBean("bankService", BankService.class);
		
		try {
			boolean status = bs.transferMoney(123456785, 123456799, 7000.00f);
			System.out.println("Money transfer request successfull : " + status);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
