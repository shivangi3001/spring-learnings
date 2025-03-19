package com.springrest.app.util;

import com.springrest.app.entity.StudentEntity;

public interface StudentUtil {
	
	//static methods in interface
	
	public static void copyNonNullProperties(
			StudentEntity dbEntity, 
			StudentEntity requestEntity ) {
		
		if(requestEntity.getEmail()!=null) {
			dbEntity.setEmail(requestEntity.getEmail());
		}
		if(requestEntity.getName()!=null) {
			dbEntity.setName(requestEntity.getName());
		}
		if(requestEntity.getCourse()!=null) {
			dbEntity.setCourse(requestEntity.getCourse());
		}
		
	}

}
