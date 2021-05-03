package com.microservice.group.shopserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ShopServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServiceClientApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getTemplplate()
	{
		return new RestTemplate();
	}

}
