package com.springrest.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private String streetLocation;
	private String city;
	private String pinCode;

}
