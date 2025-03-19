package com.springsecurity.app.config;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestValidationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//check if the request id exists in the header
		
		String requestId = req.getHeader("Request-Id");
		if(requestId==null || requestId.isEmpty()) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		//proceed to the next filter if the request id is available
		chain.doFilter(req, resp);
		
	}

}
