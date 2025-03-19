package com.app.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//target spring bean class :: user-defined

@Component("holiday")
public class Holidays {
	
	@Autowired
	@Qualifier("date")
	private Date date;
	
	public void checkHoliday() {
		if(date.getMonth()==7) {
			if(date.getDate()==8) {
				System.out.println("today is leave day...weekend");
			}
			else {
				System.out.println("no leave in the given date in aug");
			}
		}
	}
	

}
