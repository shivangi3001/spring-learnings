package com.springrest.app.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobExecutionListenerImpl implements JobExecutionListener {
	
	public void beforeJob(JobExecution jobExecution) {
		
		System.out.println("Before Executing Job");
		
	}

	
	public void afterJob(JobExecution jobExecution) {
		System.out.println("After Executing Job");
	}

}
