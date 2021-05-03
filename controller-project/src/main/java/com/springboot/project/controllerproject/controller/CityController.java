package com.springboot.project.controllerproject.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.controllerproject.pojo.Shop;
import com.springboot.project.controllerproject.repository.ShopRepository;

@RestController
@RequestMapping("/shop")
public class CityController {
	
	Logger logger=LoggerFactory.getLogger(CityController.class);

	@Autowired
	private ShopRepository repository;
	
	@GetMapping("/getShopDetails")
	@ApiOperation(value="Get all shop listed", 
				notes="Get details of all shops from database",
				response=List.class)
	public List<Shop> getShopDetails()
	{
		logger.trace("Method getShopDetails started");
		List<Shop> list=repository.findAll();
		logger.trace("Method getShopDetails returning");
		return list;
	}
	
	@ApiOperation(value="Get shop details using shopId",
			notes="Get details of any shop from database using shopId",
			response=Shop.class)
	@GetMapping("/getShopDetails/{shopId}")
	public Shop getShopDetailsById(@ApiParam(value="shopId to fetch shop details") @PathVariable("shopId") String shopId)
	{
		logger.trace("Method getShopDetailsById started");
		Shop s=repository.findById(Integer.parseInt(shopId)).orElse(null);
		logger.trace("Method getShopDetailsById returning"+s);
		return s;
	}
	
	@DeleteMapping("/deleteShop/{shopId}")
	public String deleteShop(@PathVariable("shopId") String shopId)
	{
		logger.trace("Method deleteShop started");
		repository.deleteById(Integer.parseInt(shopId));
		logger.trace("Shop deleted");
		return "Shop deleted";
	}
}
