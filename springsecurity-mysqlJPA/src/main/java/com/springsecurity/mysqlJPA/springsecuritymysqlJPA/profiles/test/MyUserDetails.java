package com.springsecurity.mysqlJPA.springsecuritymysqlJPA.profiles.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Profile(value="test")
public class MyUserDetails implements UserDetails{

	private String userName;
	
	private String password;
	
	
	private List<GrantedAuthority> roles;
	
	private String active;
	
	public MyUserDetails(User findByUsername) {
		this.userName=findByUsername.getUserName();
		this.password=findByUsername.getPassword();
		this.roles=Arrays.asList(findByUsername.getRoles().split(",")).stream().map(s->new SimpleGrantedAuthority(s)).collect(Collectors.toList());
		this.active=findByUsername.getActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return active.equals("1");
	}

	@Override
	public boolean isAccountNonLocked() {
		return active.equals("1");
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return active.equals("1");
	}

	@Override
	public boolean isEnabled() {
		return active.equals("1");
	}

}
