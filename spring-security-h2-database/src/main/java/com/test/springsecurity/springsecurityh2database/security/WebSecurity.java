package com.test.springsecurity.springsecurityh2database.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		//following is added when we have different schema
		.usersByUsernameQuery("select username,password,enabled "
				+ "from users "
				+ "where username=?")
		.authoritiesByUsernameQuery("select username,authority "
				+ "from authorities "
				+ "where username=?");
		

//following is added when we have setup schema and users through sl files	
		
//		auth.jdbcAuthentication()
//		.dataSource(dataSource);

		
//following is added when we are working with defaultschema and defaultdata
		
			/*auth.jdbcAuthentication()
			.dataSource(dataSource)
			.withDefaultSchema()
			.withUser(User.withUsername("user1")
					.password("abcd").roles("USER"))
			.withUser(User.withUsername("admin")
					.password("sun").roles("ADMIN"));*/
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		.antMatchers("/admin/*").hasRole("ADMIN")
		.antMatchers("/user/*").hasAnyRole("ADMIN","USER")
		.antMatchers("/").permitAll()
		.antMatchers("/h2-console/*").permitAll()
		.and().formLogin();
		
		httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}
