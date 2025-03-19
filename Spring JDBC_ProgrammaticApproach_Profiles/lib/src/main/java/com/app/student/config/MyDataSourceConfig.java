package com.app.student.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.app.student.dao")
public class MyDataSourceConfig {
      
	private static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String PSQL_DRIVER="org.postgresql.Driver";
	
	
	@Bean
	@Profile({"dev"})
	public  DataSource getC3PODS() throws Exception {
		System.out.println("MyDataSourceConfig.getC3PODS()");
		
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setDriverClass(MYSQL_DRIVER);
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/finisher_batch");
		ds.setUser("root");
		ds.setPassword("Ankit@$7668");
		
		return ds;
	}
	
	@Bean
	@Profile({"test"})
	public DataSource getApacheDbcp2DS() throws Exception {
		System.out.println("MyDataSourceConfig.getApacheDbcp2DS()");
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(MYSQL_DRIVER);
		ds.setUrl("jdbc:mysql://localhost:3306/finisher_batch");
		ds.setUsername("root");
		ds.setPassword("Ankit@$7668");
		
		return ds;
	}
	
	
	@Bean
	@Profile({"prod", "uat"})
	public DataSource getHikariCpDs() throws Exception {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(PSQL_DRIVER);
		ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
		ds.setUsername("postgres");
		ds.setPassword("root");
		return ds;
	}
	
	
	
	@Bean
	@Profile({"test"})
	public JdbcTemplate getJdbcTemplateUsingDbcpDs() throws Exception {
		System.out.println("MyDataSourceConfig.getJdbcTemplateUsingDbcpDs()");
		return new JdbcTemplate(getApacheDbcp2DS());
	}
	
	
	@Bean
	@Profile({"dev"})
	public JdbcTemplate getJdbcTemplateUsingC3PODS() throws Exception {
		
		System.out.println("MyDataSourceConfig.getJdbcTemplateUsingC3PODS()");
		return new JdbcTemplate(getC3PODS());
	}
	
	
	@Bean
	@Profile({"uat", "prod"})
	public JdbcTemplate getJdbcTemplateUsingHikariDs() throws Exception {
		System.out.println("MyDataSourceConfig.getJdbcTemplateUsingHikariDs()");
		return new JdbcTemplate(getHikariCpDs());
	}
	
	
	
}
