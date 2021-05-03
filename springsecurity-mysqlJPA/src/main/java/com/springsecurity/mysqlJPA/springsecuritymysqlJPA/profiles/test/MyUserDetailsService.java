package com.springsecurity.mysqlJPA.springsecuritymysqlJPA.profiles.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Profile(value="test")
@Service
public class MyUserDetailsService implements UserDetailsService{

	private Logger logger=LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		logger.info("local logs Method start MyUserDetailsService->loadUserByUsername");
		User user=userRepository.findByUserName(username);
		if(user==null)
			throw new UsernameNotFoundException("Username & password is invalid");
		
		return new MyUserDetails(user);
	}
	

}
