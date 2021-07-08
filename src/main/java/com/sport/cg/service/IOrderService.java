package com.sport.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Orders;

@Service
public interface IOrderService {
	
	public Orders addOrder(Orders order);
	public Orders removeOrder(Long id);
	public Orders  updateOrder(Long id, Orders order);
	public Orders  getOrderDetails(Long id);
	public List<Orders> getAllOrders(); 

}
