package com.app.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;


@Component("loanCalCi")
public class BankLoanInteresetCalculator_CI implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		
		System.out.println("loan interest:: ci");
		//code to cal ci
		float p = (float)args[0];
		float r = (float)args[1];
		float t = (float)args[2];
		
		
		float ci = (float)(p*Math.pow((1+r/100),t)-p);
		
		
		return ci;
	}

}
