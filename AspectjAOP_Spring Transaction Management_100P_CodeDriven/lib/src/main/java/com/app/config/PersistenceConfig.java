package com.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = "com/app/commons/jdbc.properties")
@ComponentScan(basePackages = "com.app.dao")
public class PersistenceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "hikariDs")
	public DataSource getHikariDs() {
		HikariDataSource ds = new HikariDataSource();
		
		ds.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		ds.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.password"));
		ds.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("jdbc.maxPoolSize")));
		ds.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("jdbc.minIdle")));
		
		return ds;
	}
	
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate createJdbcTemplate() {
		return new JdbcTemplate(getHikariDs());
	}
	
	
	
	
	
	
	
	
	
	
	

}
