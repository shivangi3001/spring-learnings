package com.app.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.app.bank.service.BankService;

@SpringBootApplication
public class Proj65SpringBootDistributedTxMgmtApplication {

	public static void main(String[] args) {
		ApplicationContext context = null;
		
		
		context = SpringApplication.run(Proj65SpringBootDistributedTxMgmtApplication.class, args);
		
		BankService bs = context.getBean("bankService", BankService.class);
		
		try {
			bs.transferMoney(9001, 10010, 9000.00f);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			((AbstractApplicationContext)context).close();
		}
	}

}
