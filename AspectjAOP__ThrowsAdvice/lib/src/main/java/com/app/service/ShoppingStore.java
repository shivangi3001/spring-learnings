package com.app.service;

import java.util.Arrays;

public class ShoppingStore {
	
	public float generateBill(String[] items, float[] prices) {
		
		//flag
		 boolean someProblem = false;
		 float totalBillAmt = 0.0f;
		 
		 if(items==null || prices==null) {
			 someProblem = true;
		 }
		 
		 for(float p: prices) {
			 if(p<=0.0f) {
				 someProblem = true;
				 break;
			 }
		 }
		 
		 if(someProblem) {
			 throw new IllegalArgumentException("Invalid inputs by the user");
			 
		 }
		 else {
			 for(float p: prices) {
				 totalBillAmt = totalBillAmt + p;
			 }
			 System.out.println("Items purchased : " + Arrays.deepToString(items));
		 }
		return totalBillAmt;
	}


}
