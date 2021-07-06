package com.sport.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Orders;

@Service
public interface IOrderService {
	
	public Orders addOrder(Orders order);
	public Orders removeOrder(long id);
	public Orders  updateOrder(long id, Orders order);
	public Orders  getOrderDetails(long id);
	public List<Orders> getAllOrders(); 

}
