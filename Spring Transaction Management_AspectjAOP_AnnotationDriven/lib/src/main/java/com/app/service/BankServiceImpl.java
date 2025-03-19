package com.app.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BankDao;

@Service("bankService")
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDao bankDao;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, timeout = 10, rollbackFor = SQLException.class)
	public boolean transferMoney(long srcAccount, long destAccount, float amount) throws Exception {
		
		boolean flag = false;
		
		int count1 = bankDao.withdrawMoney(srcAccount, amount);
		int count2 = bankDao.depositeMoney(destAccount, amount);
		
		
		if(count1==0 || count2==0) {
			throw new SQLException("Internal problem in money transferring. Your request cannot be processed at this time");
		}
		else {
			flag = true;
		}
		
		return flag;
	}

}
