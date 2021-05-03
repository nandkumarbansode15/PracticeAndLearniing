package com.springboot.project.controllerproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.project.controllerproject.pojo.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
	
}
