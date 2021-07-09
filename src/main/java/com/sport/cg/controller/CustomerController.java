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
	
	@GetMapping("/customersAll")
	public ResponseEntity<List<Customer>> getAllCustomers(){
	return ResponseEntity.ok().body( customerService.getAllCustomers());
	}
	
	@GetMapping("/customersId/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long cusId){
	return ResponseEntity.ok().body( customerService.getCustomerById(cusId));
	}
	
	@PostMapping("/customersAdd")
	public ResponseEntity<Customer> addCustomer(@Validated @RequestBody Customer customer){
	return ResponseEntity.ok().body(this.customerService.addCustomer(customer));
	}
	
	@PutMapping("/customersUpdate/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long cusId, @Validated @RequestBody Customer customer){
	customer.setId(cusId);
	return ResponseEntity.ok().body(this.customerService.updateCustomer(customer));
	}

	@DeleteMapping("customersDelete/{id}")
	public HttpStatus deleteCustomer(@PathVariable Long cusId) {
	this.customerService.deleteCustomer(cusId);
	return HttpStatus.OK;
	}
	
}
