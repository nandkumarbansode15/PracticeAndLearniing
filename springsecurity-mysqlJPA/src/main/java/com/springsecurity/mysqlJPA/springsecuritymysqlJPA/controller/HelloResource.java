package com.springsecurity.mysqlJPA.springsecuritymysqlJPA.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class HelloResource {
	
	
	Logger logger=LoggerFactory.getLogger(HelloResource.class);
	
	@Value("${value.from.file}")
	private String propertyValue;
	
	@RequestMapping("/")
	@ResponseBody
	public String hello()
	{
		return "Welcome " +propertyValue ;
	}
	
	@RequestMapping("/user/{user}")
	@ResponseBody
	public String user(@PathVariable String user)
	{
		return "<h1> Welcome "+user+"</h1>";
	}
	
	@RequestMapping("/admin/{admin}")
	@ResponseBody
	public String admin(@PathVariable String admin)
	{
		return "<h1> Welcome "+admin+"</h1>";
	}
	
}
