package com.microservice.group.shopserviceclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.group.shopserviceclient.pojo.Customer;
import com.microservice.group.shopserviceclient.pojo.Shop;

@RestController
@RequestMapping("/showShop")
public class ShopServiceController {
	
	@Autowired
	private RestTemplate template;
	@RequestMapping("/{shopNumber}")
	public Shop showShopDetails(@PathVariable String shopNumber)
	{
		return new Shop("Sahaj bhel","Pune",template.getForObject("http://customer-info-service/customerDetails/"+shopNumber, Customer.class));
	}
	
	

}
