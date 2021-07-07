package com.sport.cg.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.Cart;
import com.sport.cg.exception.CartNotFoundException;
import com.sport.cg.repository.ICartRepository;

@Service
public class CCartService implements ICartService {

static final Logger LOGGER = LoggerFactory.getLogger(CCartService.class);
	
	@Autowired 
	private ICartRepository iCartRepository; 
	
	@Override
	public Cart addCart(Cart cartEntity)  {
		LOGGER.info("addtocart() service is initiated");
		Cart addedCart = iCartRepository.save(cartEntity);
		LOGGER.info("addtocart() service has Executed");
		return addedCart;
	}

	@Override
	public Cart deleteCart(long id)  {
		LOGGER.info("deletecart() service is initiated");
		Cart carEntity = iCartRepository.findById(id).orElse(null);
		if (carEntity==null) {
			throw new CartNotFoundException("Cart Not Found");
		}
		else {
			iCartRepository.delete(carEntity);
			LOGGER.info("deletecart() service has Executed");
			return carEntity;
		}		
	}


	@Override
	public List<Cart> getallCartDetails() {
		LOGGER.info("getallcartdetails() service is initiated");
		List<Cart> carList = iCartRepository.findAll();
		if(carList.isEmpty()) {
			throw new CartNotFoundException("No Carts Found");
		}
		else {
			LOGGER.info("getallcartdetails() has Executed");
			return carList;
		}		
	}


}
