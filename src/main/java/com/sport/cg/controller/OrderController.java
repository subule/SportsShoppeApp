package com.sport.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.cg.entity.Orders;
import com.sport.cg.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@GetMapping("/hello/message")
	public String helloMessage() {
		System.out.println("Hello Message");
		return "From Controller";
	}
	
	@PostMapping(path="/addedOrders")
	public ResponseEntity<Orders> addOrder(@Validated @RequestBody Orders order) {
		LOGGER.info("EOrder addOrder()");
		Orders addedOrder = orderService.addOrder(order);
		return new ResponseEntity<Orders>(addedOrder, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path="/deletedOrders/{id}")
	public ResponseEntity<Orders> removeOrder(@PathVariable long id) {
		LOGGER.info("EOrder removeOrder()");
		Orders deletedOrder = orderService.removeOrder(id);
		return new ResponseEntity<Orders>(deletedOrder, HttpStatus.OK);
	}

	@PutMapping(path="/updatedOrders/{id}")
	public ResponseEntity<Orders> updateOrder(@PathVariable long id, @Validated @RequestBody Orders order) {
		LOGGER.info("EOrder updateOrder()");
		Orders updatedOrder = orderService.updateOrder(id, order);
		return new ResponseEntity<Orders>(updatedOrder, HttpStatus.OK);
	}

	@GetMapping(path="/orderDetailsById /{id}")
	public ResponseEntity<Orders> getOrderDetails(@PathVariable long id){
		LOGGER.info("EOrder getOrderDetails()");
		Orders orderDetailsById =  orderService.getOrderDetails(id);
		return new ResponseEntity<Orders>(orderDetailsById, HttpStatus.OK);
	}

	@GetMapping(path="/allOrders")
	public ResponseEntity<List<Orders>> getAllOrders() {
		System.out.println("AllOrderController");
		LOGGER.info("EOrder getAllOrders()");
		List<Orders> allOrders = orderService.getAllOrders();
		return new ResponseEntity<List<Orders>>(allOrders, HttpStatus.OK);
	}

}
