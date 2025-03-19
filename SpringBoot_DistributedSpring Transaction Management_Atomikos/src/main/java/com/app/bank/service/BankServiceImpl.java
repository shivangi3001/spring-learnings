package com.app.bank.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.app.bank.dao.DepositeDao;
import com.app.bank.dao.WithdrawDao;



@Service("bankService")
public class BankServiceImpl implements BankService {
	
	@Autowired
	private DepositeDao depositeDao;
	
	@Autowired
	private WithdrawDao withdrawDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, timeout = 10, rollbackFor = SQLException.class)
	public boolean transferMoney(int srcAccount, int destAccount, float amount) throws Exception {
		
		boolean flag = false;
		
		int count1 = withdrawDao.withdraw(srcAccount, amount);
		int count2 = depositeDao.deposite(destAccount, amount);
		
		
		if(count1==0 || count2==0) {
			throw new SQLException("Internal problem in money transferring. Your request cannot be processed at this time");
		}
		else {
			flag = true;
			System.out.println("Money transferred from  " + srcAccount + "  to   "  +  destAccount);
		}
		
		return flag;
	}

}
