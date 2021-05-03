package com.test.springsecurity.springsecurityh2database.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

	@RequestMapping("/")
	public String welcome()
	{
		return "<h1> Welcome </h1>";
	}
	
	@RequestMapping("/user/{user}")
	public String user(@PathVariable String user)
	{
		return "<h1> Welcome "+user+"</h1>";
	}
	
	@RequestMapping("/admin/{admin}")
	public String admin(@PathVariable String admin)
	{
		return "<h1> Welcome "+admin+"</h1>";
	}
}
