package com.app.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationContextEventListener  implements ApplicationListener {

	//event handler method
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		  System.out.println("ioc container ...event occured");
		  
		  System.out.println(event.toString());
		  
		  if(event instanceof ContextRefreshedEvent) {
			  System.out.println("ioc container started...");
		  }
		  else {
			  System.out.println("ioc container stopped");
		  }
		  
	}

}
