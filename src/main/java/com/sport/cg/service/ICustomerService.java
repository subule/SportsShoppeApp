package com.sport.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Customer;

@Service
public interface ICustomerService {
	
	public List<Customer>getAllCustomers();
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomerById(Long cusId);
	public Customer deleteCustomer(Long cusId);

}
