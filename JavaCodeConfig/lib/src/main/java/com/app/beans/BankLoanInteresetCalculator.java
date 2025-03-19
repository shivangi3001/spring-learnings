package com.app.beans;

import org.springframework.stereotype.Component;


public class BankLoanInteresetCalculator {
	
	public float calLoanInterest(float p, float r, float t) {
		System.out.println("loan interest:: si");
		return (p*t*r) / 100;
	}

}
