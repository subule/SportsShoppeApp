package com.sport.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.cg.entity.Cart;
import com.sport.cg.service.ICartService;

@RestController
@RequestMapping("onlinesportshopee/cart")
public class CartController {
	
static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private ICartService cartService;
	
	@PostMapping("/addtocart")
	public  ResponseEntity<Object> addtocart(@RequestBody Cart cartEntity) {
		LOGGER.info("add-cart URL is opened");
		LOGGER.info("addtocart() is initiated");
		Cart cartDTO = null;
		ResponseEntity<Object> cartResponse = null;
		cartDTO = cartService.addCart(cartEntity);
		cartResponse = new ResponseEntity<>(cartDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addtocart() has Executed");
		return cartResponse;
	}
	
	@DeleteMapping("/removefromcart/{delID}")
	public ResponseEntity<Object> deletecart(@PathVariable long delID) {
		LOGGER.info("remove-cart URL is opened");
		LOGGER.info("deletecart() is initiated");
		Cart cartDTO = cartService.deleteCart(delID);
		ResponseEntity<Object> cartResponse = new ResponseEntity<>(cartDTO, HttpStatus.ACCEPTED);
		LOGGER.info("deletecart() has Executed");
		return cartResponse;

	}
	
	@GetMapping("/getallcartdetials")
	public List<Cart> getAllProduct()
	{
		LOGGER.info("getall-cartdetails URL is opened");
		LOGGER.info("getallcartdetails() initiated");
		return cartService.getallCartDetails();
	}

	

}
