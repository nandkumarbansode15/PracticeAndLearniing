package com.spring.security.springbootspringsecurityjwt;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.springbootspringsecurityjwt.filters.JwtRequestFilter;

@Service
public class MyUserDetailsService implements UserDetailsService{

	Logger logger=LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		logger.info("local logs Method start MyUserDetailsService->loadUserByUsername");
		return new User("foo","hoo", new ArrayList<>());
	}
	

}
