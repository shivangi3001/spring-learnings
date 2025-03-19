package com.app.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionLogger {
	
	
	public  void  logException(JoinPoint jp, Exception e) throws IOException {
		System.out.println(e + " exception is raised in " +
							     jp.getSignature() +
							     " having args : " +
							     Arrays.deepToString(jp.getArgs())
				
				);
		
		FileWriter writer = new FileWriter("C:/Users/Ankit Arya Sam/Desktop/finisher9.0/error.txt", true );
		writer.write("some internal problem occured at : " + LocalDateTime.now());
		writer.flush();
		writer.close();
		
	}

}
