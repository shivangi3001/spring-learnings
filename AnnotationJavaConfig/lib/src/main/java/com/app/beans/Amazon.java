package com.app.beans;

import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("myamazon")
public class Amazon {
	
	@Resource(name = "delhivery")
	private LogisticsService logisticsService;

	@Override
	public String toString() {
		return "Amazon [logisticsService=" + logisticsService + "]";
	}
	
	
	
	

}
