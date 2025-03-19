package com.springsecurity.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyProjectConfig {
	
	@Bean
	public SmsCodeAuthProvider smsCodeAuthProvider() {
		return new SmsCodeAuthProvider();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(SmsCodeAuthProvider authProvider) {
		return new ProviderManager(authProvider);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(c-> c.anyRequest().permitAll());// Include HTTP Basic Authentication
		 
		 return http.build();
	}
}
