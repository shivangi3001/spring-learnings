package com.springsecurity.app.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.app.dto.LoginRequestDto;

@RestController
public class WelcomeController {
	
	@Autowired
	
	private AuthenticationManager authManager;
	
	@PostMapping("/welcome")
	public String welcome(@RequestBody LoginRequestDto loginRequest) {
		org.springframework.security.core.Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
		org.springframework.security.core.Authentication auth = authManager.authenticate(authentication);
		return "Welcome dear!";
	}
	
	@GetMapping("hello")
	public String hello() {
		return "Hello User!";
	}
	

}

