package com.springrest.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
	
	private Integer id;
	private String name;
	private String email;
	private String course;
    private String grade;
    private Double feeGrant;

}
