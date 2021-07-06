package com.sport.cg.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.cg.entity.Orders;
import com.sport.cg.repository.IOrderRepository;

@Service
public class COrderService implements IOrderService{

	@Autowired
	IOrderRepository orderRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(COrderService.class);

	@Override
	@Transactional
	public Orders addOrder(Orders order) {
		LOGGER.info("EOrder addOrder()");
		return orderRepository.save(order);
	}

	@Override
	@Transactional
	public Orders removeOrder(long id) {
		LOGGER.info("Orders removeOrder()");
		if (orderRepository.findById(id).isPresent()){
			orderRepository.deleteById(id);
			return null;
		}
		else {
			//else throw new OrderNotFoundException();
			return null;//FOR_THE_TIME_BEING
		}
		
	}

	@Override
	@Transactional
	public Orders updateOrder(long id, Orders order) {
		LOGGER.info("EOrder updateOrder()");
		if (orderRepository.findById(id).isPresent()) {
			Orders order2 = new Orders();
			order2.setOrderId(order.getOrderId());
			order2.setAmount(order.getAmount());
			order2.setBillingDate(order.getBillingDate());
			order2.seteCustomers(order.geteCustomers());
			orderRepository.save(order2);
			return order2;
		}
		else {
			//throws new OrderNotFoundException();
			return null;
		}
	}

	@Override
	@Transactional
	public Orders getOrderDetails(long id) {
		LOGGER.info("EOrder getOrderDetails()");
		Optional<Orders> orderById = orderRepository.findById(id) ;
		if(orderById.isPresent()) {
			Orders foundOrderById = orderById.get();
			return foundOrderById;
		}
		else {
			//throw new OrderNotFoundException();
			return null;
		}
	}

	@Override
	@Transactional
	public List<Orders> getAllOrders() {
		System.out.println("OrderService");
		LOGGER.info("EOrder getAllOrders()");
		return orderRepository.findAll();
	}
	
}
