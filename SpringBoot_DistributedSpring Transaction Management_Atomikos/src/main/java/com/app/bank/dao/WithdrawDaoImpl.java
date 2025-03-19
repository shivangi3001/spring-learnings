package com.app.bank.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("withdrawDao")
public class WithdrawDaoImpl implements WithdrawDao {
	
	
	private static final String WITHDRAW_QUERY = "UPDATE dtx_table SET balance=balance-? WHERE ac_no=?";

	
	@Autowired
	@Qualifier("psqlJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int withdraw(int accNo, float amt) {
		return jdbcTemplate.update(WITHDRAW_QUERY, amt, accNo);
	}

}
