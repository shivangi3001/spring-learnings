package com.app.beans;

public class Amazon {
	
	private Delhivery delhivery;
	
	public void setDelhivery(Delhivery delhivery) {
		this.delhivery=delhivery;
	}
	
	public Amazon() {
		System.out.println("Amazon.Amazon()");
	}
	
	
	public void shipOrder(int orderId) {
		System.out.println("Order shipped " + orderId);
	}

}
