package com.app.bank.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@ComponentScan(basePackages = "com.app.bank.dao")
public class PersistenceConfig {
	
	@Bean(name = "mysqlADS")
	public AtomikosDataSourceBean getAtomikosDsMysql() {
		
		AtomikosDataSourceBean atds = new AtomikosDataSourceBean();
		
		atds.setUniqueResourceName("mysqlXads");
		atds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		
		Properties properties = new Properties();
		properties.setProperty("databaseName", "finisher_batch");
		properties.setProperty("url", "jdbc:mysql://localhost:3306/finisher_batch");
		properties.setProperty("user", "root");
		properties.setProperty("password", "Ankit@$7668");
		
		atds.setXaProperties(properties);
		
		return atds;
		
	}
	
	@Bean(name = "psqlADS")
	public AtomikosDataSourceBean getAtomikosDsPsql() {
		
		AtomikosDataSourceBean atds = new AtomikosDataSourceBean();
		
		atds.setUniqueResourceName("psqlXads");
		atds.setXaDataSourceClassName("org.postgresql.xa.PGXADataSourcece");
		
		Properties properties = new Properties();
		properties.setProperty("databaseName", "postgres");
		properties.setProperty("url", "jdbc:postgresql://localhost:5432/postgres");
		properties.setProperty("user", "postgres");
		properties.setProperty("password", "root");
		
		atds.setXaProperties(properties);
		
		return atds;
		
	}
	
	
	
	
	
	@Bean(name = "mysqlJdbcTemplate")
	public JdbcTemplate jdbcTemplateMysql() {
		return new JdbcTemplate(getAtomikosDsMysql());
	}
	
	
	@Bean(name = "psqlJdbcTemplate")
	public JdbcTemplate jdbcTemplatePsql() {
		return new JdbcTemplate(getAtomikosDsPsql());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
