package com.app.service;

//target class 
public class BankService {
	
	public  float  calSi(float p, float r, float t) {
		System.out.println("BankService.calSi()");
		return  p*t*r / 100.0f;
	}
	
	
	public float  calCi(float p, float r, float t) {
		System.out.println("BankService.calCi()");
		float ci = (float)((p * Math.pow(1+r/100, t)))-p;
		return ci;
	}

}
