package com.springsecurity.app.config;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AuthenticationLoggingFilter  implements Filter {
	
	private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		

		String requestId = req.getHeader("Request-Id");
	
		//log the request
		logger.info("Successfully authenticated request with request-id : " + requestId);
		
		chain.doFilter(req, resp);
		
	}

}
