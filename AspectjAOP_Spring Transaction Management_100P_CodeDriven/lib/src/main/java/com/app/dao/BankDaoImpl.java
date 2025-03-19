package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class BankDaoImpl implements BankDao {

	private static final String WITHDRAW_QUERY="UPDATE bank_account SET balance=balance-? WHERE ac_no=?";
	private static final String DEPOSITE_QUERY="UPDATE bank_account SET balance=balance+? WHERE ac_no=?";
	
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	
	
	@Override
	public int withdrawMoney(long accNo, float amount) {
	   int rowAffected = jdbcTemplate.update(WITHDRAW_QUERY,amount,accNo);
	   return rowAffected;
	}

	@Override
	public int depositeMoney(long accNo, float amount) {
		int rowAffected = jdbcTemplate.update(DEPOSITE_QUERY, amount, accNo);
		return rowAffected;
	}

}
