package com.app.beans;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class WebContainer {
	
	@Lookup("rh")
    public abstract RequestHandler getRequestHandler();
    
    public void processRequest(String data) {
    	System.out.println("request reached to the server");
    	RequestHandler requestHandler = null;
    	
    	requestHandler = getRequestHandler();
    	requestHandler.handleRequest(data);
    	
    	System.out.println(requestHandler.hashCode());
    }
}
