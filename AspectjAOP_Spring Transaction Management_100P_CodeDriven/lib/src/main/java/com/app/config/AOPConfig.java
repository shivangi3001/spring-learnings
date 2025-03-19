package com.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement  // this annotation is similar to <tx:annotation-driven /> tag
public class AOPConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean(name = "dsTxMngr")
	public DataSourceTransactionManager getDsTxMngr() {
		return new DataSourceTransactionManager(dataSource);
	}

}
