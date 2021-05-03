package com.springsecurity.mysqlJPA.springsecuritymysqlJPA.profiles.production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Profile;

@Entity
@Table(name = "prod_users")
@Profile(value="production")
public class ProdUser {

	@Id
	@GeneratedValue
	private String id;
	
	@Column(name = "user_name")
	private String userName;
	
	private String password;
	
	
	private String roles;
	
	private String active;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	
	
}
