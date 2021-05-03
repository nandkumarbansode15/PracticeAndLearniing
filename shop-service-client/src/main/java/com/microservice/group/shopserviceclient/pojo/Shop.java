package com.microservice.group.shopserviceclient.pojo;

public class Shop {
	private String name;
	private String address;
	private Customer customer;
	public Shop(String name, String address, Customer customer) {
		this.name=name;
		this.address=address;
		this.customer=customer;
	}
	public Shop()
	{
		super();
	}
	public String getName() {
		return name;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
