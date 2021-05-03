package com.springboot.project.controllerproject.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
//@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
@ApiModel(description="Details about shop")
public class Shop {

	@Id
	private int shopId;
	@ApiModelProperty(notes="Name of shop")
	private String name;
	
	@ApiModelProperty(notes="Address of shop")
	private String address;
	private String city;
	private String village;
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getName() {
		return name;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", name=" + name + ", address="
				+ address + ", city=" + city + ", village=" + village + "]";
	}
	
	
}
