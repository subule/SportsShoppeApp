package com.sport.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.Customer;
import com.sport.cg.repository.ICustomerRepository;

@Service
public class CCustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepository;
	@Override
		public List<Customer> getAllCustomers() {
			return this.customerRepository.findAll();
		}

		@Override
		public Customer addCustomer(Customer customer) {
			return customerRepository.save(customer);
		}

		@Override
		public Customer updateCustomer(Customer customer) {
			Optional<Customer> customerC= this.customerRepository.findById(customer.getId());
			if(customerC.isPresent()) {
				Customer customerUpdate = customerC.get();
				customerUpdate.setId(customer.getId());
				customerUpdate.setName(customer.getName());
				customerUpdate.setEmail(customer.getEmail());
				customerUpdate.setContactNo(customer.getContactNo());
				customerUpdate.setDoB(customer.getDoB());
				customerUpdate.setAddressEntity(customer.getAddressEntity());
				customerRepository.save(customerUpdate);
				return customerUpdate;
			}else {
				//throw new CustomerNotFoundException("customer not found with id :" +customer.getCusId());
			}
			return customer;
			
		}

		@Override
		public Customer getCustomerById(long cusId) {
			Optional<Customer> customerC= this.customerRepository.findById(cusId);
			if(customerC.isPresent()) {
			return customerC.get();
		}else {
			//throw new CustomerNotFoundException("Record not found by id" +cusId);
		}
			return null;
			
		}

		@Override
		public void deleteCustomer(long cusId) {
			Optional<Customer> customerC= this.customerRepository.findById(cusId);
			if(customerC.isPresent()) {
			this.customerRepository.delete(customerC.get());
		}else {
			//throw new CustomerNotFoundException("Record not found by id" +cusId);
		}
			
	}

}
