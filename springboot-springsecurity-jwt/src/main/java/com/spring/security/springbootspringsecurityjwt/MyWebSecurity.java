package com.spring.security.springbootspringsecurityjwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.security.springbootspringsecurityjwt.filters.JwtRequestFilter;

@EnableWebSecurity
public class MyWebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	Logger logger=LoggerFactory.getLogger(JwtRequestFilter.class);
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		logger.info("local logs Method start MyWebSecurity->configure");
		auth.userDetailsService(userDetailsService);
		logger.info("local logs Method end MyWebSecurity->configure");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("local logs Method start MyWebSecurity->configure(HttpSecurity http)");
	http.csrf().disable()
		.authorizeRequests().antMatchers("/authenticate").permitAll()
		.anyRequest().authenticated().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	logger.info("local logs Method end MyWebSecurity->configure(HttpSecurity http)");
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		logger.info("local logs Method start MyWebSecurity->authenticationManagerBean()");
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder getEncoder()
	{
		logger.info("local logs Method start MyWebSecurity->getEncoder()");
		return NoOpPasswordEncoder.getInstance();
	}
}
