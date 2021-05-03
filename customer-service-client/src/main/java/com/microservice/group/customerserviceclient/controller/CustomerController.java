package com.microservice.group.customerserviceclient.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.group.customerserviceclient.pojo.Customer;


@RestController
@RequestMapping("/customerDetails")
public class CustomerController {

	@RequestMapping("/{customerId}")
	public Customer getCustDetails(@PathVariable String customerId)
	{
		return new Customer("Nandu","987654321");
	}

}
