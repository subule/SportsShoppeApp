package com.sport.cg.controller;

import java.util.List;

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

import com.sport.cg.entity.Customer;
import com.sport.cg.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
	return ResponseEntity.ok().body( customerService.getAllCustomers());
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long cusId){
	return ResponseEntity.ok().body( customerService.getCustomerById(cusId));
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@Validated @RequestBody Customer customer){
	return ResponseEntity.ok().body(this.customerService.addCustomer(customer));
	}
	
	@PutMapping("/Customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long cusId, @Validated @RequestBody Customer customer){
	customer.setId(cusId);
	return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
	}

	@DeleteMapping("customer/{id}")
	public HttpStatus deleteCustomer(@PathVariable long cusId) {
	this.customerService.deleteCustomer(cusId);
	return HttpStatus.OK;
	}
	
}
