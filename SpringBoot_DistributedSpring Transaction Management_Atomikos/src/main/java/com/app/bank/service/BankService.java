package com.app.bank.service;

public interface BankService {
	
	public boolean transferMoney(int srcAccount, int destAccount, float amount) throws Exception;

}
