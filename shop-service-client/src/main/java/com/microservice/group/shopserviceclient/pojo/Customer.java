package com.microservice.group.shopserviceclient.pojo;

public class Customer {

	private String name;
	private String mobile;
	
	public Customer()
	{
		super();
	}
	public Customer(String name, String mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
