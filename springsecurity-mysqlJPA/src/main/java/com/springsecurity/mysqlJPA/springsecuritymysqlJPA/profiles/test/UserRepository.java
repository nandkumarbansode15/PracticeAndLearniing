package com.springsecurity.mysqlJPA.springsecuritymysqlJPA.profiles.test;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile(value="test")
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	public User findByUserName(String username);

}
