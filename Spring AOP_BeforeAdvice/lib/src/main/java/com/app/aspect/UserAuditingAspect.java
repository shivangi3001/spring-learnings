package com.app.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import javax.sql.rowset.Joinable;

import org.aspectj.lang.JoinPoint;

public class UserAuditingAspect {
	
	public  void  audit(String  model) throws Throwable {
		System.out.println("UserAuditingAspect.audit()");
		
//		java code - text file
		
		FileWriter writer = new FileWriter("C:/Users/Ankit Arya Sam/Desktop/finisher9.0/user_audit_file.txt", true);
		writer.write(model + " model laptop is getting used by the user at : " + LocalDate.now() );
		writer.flush();
		writer.close();
	}

}
