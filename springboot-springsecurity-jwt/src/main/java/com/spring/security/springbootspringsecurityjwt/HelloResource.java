package com.spring.security.springbootspringsecurityjwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.security.springbootspringsecurityjwt.model.AuthenticationRequest;
import com.spring.security.springbootspringsecurityjwt.model.AuthenticationResponse;
import com.spring.security.springbootspringsecurityjwt.util.JWTUtil;

@Controller
public class HelloResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetails;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	Logger logger=LoggerFactory.getLogger(HelloResource.class);
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello()
	{
		return "Hello world";
	}
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception
	{
		logger.info("local logs Method start HelloResource->createAuthenticationToken");
		
		try{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			logger.info("local logs Method createAuthenticationToken-> user is verified");
		}catch(BadCredentialsException e)
		{
			throw new Exception("Incorrect username and password");
		}
		
		UserDetails userDetails= myUserDetails.loadUserByUsername(request.getUsername());
		
		final String jwt=jwtUtil.generateToken(userDetails);
		
		logger.info("local logs Method end HelloResource->createAuthenticationToken");
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
}
