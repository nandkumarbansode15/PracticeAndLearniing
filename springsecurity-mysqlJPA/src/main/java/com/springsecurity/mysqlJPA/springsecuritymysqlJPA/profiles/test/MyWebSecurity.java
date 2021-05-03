package com.springsecurity.mysqlJPA.springsecuritymysqlJPA.profiles.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Profile(value="test")
public class MyWebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	Logger logger=LoggerFactory.getLogger(MyWebSecurity.class);
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		logger.info("local logs Method start MyWebSecurity->configure");
		auth.userDetailsService(userDetailsService);
		logger.info("local logs Method end MyWebSecurity->configure");
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		logger.info("local logs Method start MyWebSecurity->configure(HttpSecurity http)");
		httpSecurity.authorizeRequests()
		.antMatchers("/admin/*").hasRole("ADMIN")
		.antMatchers("/user/*").hasAnyRole("ADMIN","USER")
		.antMatchers("/").permitAll()
		.and().formLogin();
		
        
	logger.info("local logs Method end MyWebSecurity->configure(HttpSecurity http)");
	}
	
	
	@Bean
	public PasswordEncoder getEncoder()
	{
		logger.info("local logs Method start MyWebSecurity->getEncoder()");
		return NoOpPasswordEncoder.getInstance();
	}
}
