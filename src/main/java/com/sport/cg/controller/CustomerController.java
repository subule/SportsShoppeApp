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
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
	return ResponseEntity.ok().body( customerService.getCustomerById(id));
	}
	
	@PostMapping("/customersAdd")
	public ResponseEntity<Customer> addCustomer(@Validated @RequestBody Customer customer){
	return ResponseEntity.ok().body(this.customerService.addCustomer(customer));
	}
	
	@PutMapping("/customersUpdate/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Validated @RequestBody Customer customer){
	customer.setId(id);
	return ResponseEntity.ok().body(this.customerService.updateCustomer(id, customer));
	}

	@DeleteMapping("customersDelete/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
	return ResponseEntity.ok().body(this.customerService.deleteCustomer(id));
	}
	
}
