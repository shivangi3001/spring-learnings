package com.springsecurity.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome dear!";
	}
	
	@GetMapping("/test")
	public String test() {
		return "Welcome testing here!";
	}

}

