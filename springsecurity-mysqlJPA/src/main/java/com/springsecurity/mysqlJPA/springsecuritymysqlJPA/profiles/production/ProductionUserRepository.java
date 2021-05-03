package com.springsecurity.mysqlJPA.springsecuritymysqlJPA.profiles.production;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile(value="production")
public interface ProductionUserRepository extends JpaRepository<ProdUser, Integer> {
	
	
	public ProdUser findByUserName(String username);

}
