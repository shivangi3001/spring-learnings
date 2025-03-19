package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.beans.BankLoanInteresetCalculator;
import com.app.beans.Holidays;
import com.app.config.MyAppConfig;

public class JavaCodeConfigTest {
  public static void main(String[] args) {
	
	  
	   ApplicationContext context = null;
	   context = new AnnotationConfigApplicationContext(MyAppConfig.class);
       Holidays hol = context.getBean("holiday", Holidays.class);
       
       hol.checkHoliday();
       
        BankLoanInteresetCalculator loanCal = context.getBean("loanCal", BankLoanInteresetCalculator.class);
	    float si = loanCal.calLoanInterest(1000, 12, 2);
	    System.out.println(si);
  }
}
