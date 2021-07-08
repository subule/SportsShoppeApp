package com.sport.cg.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.cg.entity.Orders;
import com.sport.cg.exception.OrderNotFoundException;
import com.sport.cg.repository.IOrderRepository;

@Service
public class COrderService implements IOrderService{

	@Autowired
	private IOrderRepository orderRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(COrderService.class);

	@Override
	@Transactional
	public Orders addOrder(Orders order) {
		LOGGER.info("EOrder addOrder()");
		return orderRepository.save(order);
	}

	@Override
	@Transactional
	public Orders removeOrder(Long id) {
		LOGGER.info("Orders removeOrder()");
		Optional<Orders> removedOrder = orderRepository.findById(id);
		if (removedOrder.isPresent()){
			orderRepository.deleteById(id);
			return removedOrder.get();
		}
		else {
			throw new OrderNotFoundException("Order record not found");
		}
		
	}

	@Override
	@Transactional
	public Orders updateOrder(Long id, Orders order) {
		LOGGER.info("EOrder updateOrder()");
		Optional<Orders> updatedOrder = orderRepository.findById(id);
		if (updatedOrder.isPresent()) {
			return orderRepository.save(updatedOrder.get());
		}
		else {
			throw new OrderNotFoundException("Order Not Updated. Order Not Found");
		}
	}

	@Override
	@Transactional
	public Orders getOrderDetails(Long id) {
		LOGGER.info("EOrder getOrderDetails()");
		Optional<Orders> orderById = orderRepository.findById(id) ;
		if(orderById.isPresent()) {
			Orders foundOrderById = orderById.get();
			return foundOrderById;
		}
		else {
			throw new OrderNotFoundException("Order Record Not Found");
		}
	}

	@Override
	@Transactional
	public List<Orders> getAllOrders() {
		LOGGER.info("EOrder getAllOrders()");
		List<Orders> allOrders = orderRepository.findAll();
		if(allOrders.isEmpty()) {
			throw new OrderNotFoundException("No Orders Found");
		}
		else {
			return orderRepository.findAll();
		}		
	}
	
}
