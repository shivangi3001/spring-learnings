package com.app.service;

public class LaptopShowRoom {
	
	
	public   String   sale(String model, float price, String sellerName) {
		
		System.out.println("LaptopShowRoom.sale()");
		
		if(model.equalsIgnoreCase("tuf-series") 
				 || 
	      model.equalsIgnoreCase("rog-series")) {
			return  model + " this laptop is sold out at price " + 
	        price + 
	        " by " + sellerName; 
		}
		
		else {
			return model + " this model is not available for sale";
		}
		
		
	}

}
