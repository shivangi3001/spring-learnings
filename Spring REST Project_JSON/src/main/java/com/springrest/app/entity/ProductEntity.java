package com.springrest.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	
	private String title;
	private Float price;
	
	private SellerEntity seller;

}
