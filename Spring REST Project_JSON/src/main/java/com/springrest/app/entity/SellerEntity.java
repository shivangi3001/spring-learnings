package com.springrest.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerEntity {
	
	private String businessName;
	private Byte rating;
	
	private Address sellerBusinessAddress;

}
