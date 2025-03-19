package com.springsecurity.app.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SmsCodeAuthProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Extract the username and code
        String username = authentication.getName();
        String code = (String) authentication.getCredentials();

        // Custom authentication logic
        if ("manish_og".equals(username) && "9866".equals(code)) {
            User user = new User(username, "", true, true, true, true, getAuthorities());
            return new UsernamePasswordAuthenticationToken(user, code, user.getAuthorities());
        } else {
            throw new BadCredentialsException("Invalid username or code");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Indicate that this provider supports UsernamePasswordAuthenticationToken
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
