package com.sport.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.Customer;
import com.sport.cg.exception.CustomerNotFoundException;
import com.sport.cg.repository.ICustomerRepository;

@Service
public class CCustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepository;
	
		@Override
		public List<Customer> getAllCustomers() {
			List<Customer> allCustomers = customerRepository.findAll();
			if (allCustomers.isEmpty()) {
				throw new CustomerNotFoundException("No Customers Found");
			}
			else {
				return allCustomers;
			}
		}

		@Override
		public Customer addCustomer(Customer customer) {
			return customerRepository.save(customer);
		}

		@Override
		public Customer updateCustomer(Customer customer) {
			Optional<Customer> customerC= this.customerRepository.findById(customer.getId());
			Customer updatedCustomer = new Customer();
			if(customerC.isPresent()) {
				updatedCustomer = customerRepository.save(customer);
				return updatedCustomer;
			}else {
				throw new CustomerNotFoundException("Customer cannot be Updated. Customer cannot be found.");
			}
		}

		@Override
		public Customer getCustomerById(long cusId) {
			Optional<Customer> customerC= this.customerRepository.findById(cusId);
			if(customerC.isPresent()) {
				return customerC.get();
			}
			else {
				throw new CustomerNotFoundException("Customer Record Not Found");
			}			
		}

		@Override
		public Customer deleteCustomer(long cusId) {
			Optional<Customer> deletedCard = this.customerRepository.findById(cusId);
			if(deletedCard.isPresent()) {
				customerRepository.delete(deletedCard.get());
			}
			else {
				throw new CustomerNotFoundException("Record not found by id" +cusId);
			}
			return deletedCard.get();
		}

}
