package com.app.dao;

public interface BankDao {
	
	public int withdrawMoney(long accNo, float amount);
	public int depositeMoney(long accNo, float amount);

}
