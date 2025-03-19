package com.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoringAroundAspect {
	
	public  Object  monitorPerformance(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("PerformanceMonitoringAroundAspect.monitorPerformance()");
		
		System.out.println("prelogic : PerformanceMonitoringAspect");
		//pre-logic
		long startTime = System.currentTimeMillis();
		
		//execute the target method
		Object returnedValue =pjp.proceed();
		
		//post-logic
		System.out.println("postlogic : PerformanceMonitoringAspect");
		long endTime = System.currentTimeMillis();
		
		System.out.println(pjp.getSignature() + " has taken " + 
							(endTime-startTime) +
							"ms" + " to execute");
		
		
		return returnedValue;
		
	}

}
