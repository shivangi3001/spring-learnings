package com.app.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AopConfig {
	
	//tx service
	@Bean(name = "atxService")
	public UserTransactionImp getUserTransactionImp() {
		return new UserTransactionImp();
	}
	
	
	//tx manager
	@Bean(name="atxMgr")
	public UserTransactionManager getUserTransactionManager() {
		return new UserTransactionManager();
	}
	
	
	//jta txmgr
	@Bean(name = "jtaTxMgr")
	public JtaTransactionManager getJtaTxMgr() {
		JtaTransactionManager jtaTxMgr = new JtaTransactionManager();
		jtaTxMgr.setUserTransaction(getUserTransactionImp());
		jtaTxMgr.setTransactionManager(getUserTransactionManager());
		
		return jtaTxMgr;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
