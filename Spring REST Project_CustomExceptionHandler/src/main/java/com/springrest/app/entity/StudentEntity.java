package com.springrest.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_crud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
	
	@Id
	private Integer id;
	private String name;
	private String email;
	private String course;
    private String grade;
    private Double feeGrant;

}
