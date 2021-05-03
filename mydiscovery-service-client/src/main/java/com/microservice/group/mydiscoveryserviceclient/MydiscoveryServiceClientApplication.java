package com.microservice.group.mydiscoveryserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MydiscoveryServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydiscoveryServiceClientApplication.class, args);
	}

}
