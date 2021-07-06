package com.sport.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Cart;

@Service
public interface ICartService {
	
	public Cart addCart(Cart cartEntity);
	public Cart deleteCart(long id);
	public List<Cart> getallCartDetails();
	

}
