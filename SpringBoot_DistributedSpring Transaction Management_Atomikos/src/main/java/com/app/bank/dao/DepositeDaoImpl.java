package com.app.bank.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDao")
public class DepositeDaoImpl implements DepositeDao {
	
	
	private static final String DEPOSITE_QUERY = "UPDATE dtx_table SET balance=balance+? WHERE ac_no=?";
	
	
	
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private  JdbcTemplate jdbcTemplate;
	
	


	@Override
	public int deposite(int accNo, float amt) {
		int affectedRowCount = 0;
		
		affectedRowCount = jdbcTemplate.update(DEPOSITE_QUERY, amt, accNo);
		return affectedRowCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
