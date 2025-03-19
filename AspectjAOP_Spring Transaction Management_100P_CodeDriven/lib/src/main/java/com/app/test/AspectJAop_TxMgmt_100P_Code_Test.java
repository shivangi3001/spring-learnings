package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.config.MainConfig;
import com.app.service.BankService;

public class AspectJAop_TxMgmt_100P_Code_Test {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = null;
		
		
		context = new AnnotationConfigApplicationContext(MainConfig.class);
		
		BankService bs = context.getBean("bankService", BankService.class);
		
		try {
			boolean status = bs.transferMoney(123456785, 123456788, 5000.00f);
			System.out.println("Money transfer request successfull : " + status);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
