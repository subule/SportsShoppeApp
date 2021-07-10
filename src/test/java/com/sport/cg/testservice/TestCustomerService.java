package com.sport.cg.testservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sport.cg.entity.Address;
import com.sport.cg.entity.Customer;
import com.sport.cg.repository.ICustomerRepository;
import com.sport.cg.service.ICustomerService;

@SpringBootTest
class TestCustomerService {

	@MockBean
	ICustomerRepository customerRepository;
	
	@Autowired
	ICustomerService customerService;
	
	@Test
	void testAddCustomer(){
		Address a = new Address();
		List<Address> aList = new ArrayList<Address>();
		a.setAddrId(1L);
		a.setArea("rampur");
		a.setCity("rajamundry");
		a.setPincode(241356);
		a.setStreet("industrial");
		a.setState("AndraPradesh");
		aList.add(a);
		
		Customer c1 = new Customer();
		c1.setId(133L);
		c1.setName("sunil");
		c1.setEmail("sunilk@gmail.com");
		c1.setDoB(LocalDate.of(1996, 11, 13));
		c1.setContactNo("9865407654");
		c1.setCustOrderEntity(null);
		c1.setAddressEntity(aList);
	
		
		Mockito.when(customerRepository.save(c1)).thenReturn(c1);
		Customer returned = customerService.addCustomer(c1);
		assertThat(returned).isEqualTo(c1);
	}

	@Test
	void testDeleteCustomer() {
		Address a2 = new Address();
		List<Address> a4List = new ArrayList<Address>();
		a2.setAddrId(43L);
		a2.setArea("nampally");
		a2.setCity("Hyderabad");
		a2.setPincode(221356);
		a2.setStreet("sr colony");
		a2.setState("Telangana");
		a4List.add(a2);
		
		Customer c2 = new Customer();
		c2.setId(12L);
		c2.setName("rishi");
		c2.setEmail("rishiraj@gmail.com");
		c2.setDoB(LocalDate.of(1997, 01, 21));
		c2.setContactNo("9567801234");
		c2.setCustOrderEntity(null);
		c2.setAddressEntity(a4List);
		
		Optional<Customer> cus = Optional.of(c2);
		Mockito.when(customerRepository.findById(12L)).thenReturn(cus);
		Mockito.when(customerRepository.existsById(c2.getId())).thenReturn(false);
		assertFalse(customerRepository.existsById(c2.getId()));
		
	}

	@Test
	void testUpdateCustomer() {
		Address a4 = new Address();
		List<Address> a4List = new ArrayList<Address>();
		a4.setAddrId(433L);
		a4.setArea("wadepally");
		a4.setCity("warangal");
		a4.setPincode(221336);
		a4.setStreet("ngos colony");
		a4.setState("Telangana");
		a4List.add(a4);
		
		Customer c23 = new Customer();
		c23.setId(13L);
		c23.setName("sowmya");
		c23.setEmail("sowmyareddy@gmail.com");
		c23.setDoB(LocalDate.of(1998, 07, 20));
		c23.setContactNo("9807654321");
		c23.setCustOrderEntity(null);
		c23.setAddressEntity(a4List);
		
		
		 Optional<Customer> c =Optional.of(c23);
	     Mockito.when(customerRepository.findById(13L)).thenReturn(c);
	     c23.setEmail("stephen22@gmail.com");
		 Mockito.when(customerRepository.save(c23)).thenReturn(c23);
		 assertThat(customerService.updateCustomer(13L, c23)).isEqualTo(c23);
	}

	@Test
	void testGetCustomerDetails() {	
		Address a14 = new Address();
		List<Address> a14List = new ArrayList<Address>();
		a14.setAddrId(124L);
		a14.setArea("Area41");
		a14.setCity("City14");
		a14.setPincode(244456);
		a14.setStreet("Street41");
		a14.setState("State14");
		a14List.add(a14);
		
		Customer c141 = new Customer();
		c141.setId(121L);
		c141.setName("Name14");
		c141.setEmail("email441@email.com");
		c141.setDoB(LocalDate.of(1994, 12, 04));
		c141.setContactNo("9953444680");
		c141.setCustOrderEntity(null);
		c141.setAddressEntity(a14List);
		
		Optional<Customer> cu = Optional.of(c141);
		
		Mockito.when(customerRepository.findById(121L)).thenReturn(cu);
	    assertThat(customerService.getCustomerById(121L)).isEqualTo(c141);
	}

	@Test
	void testGetAllCustomers() {		
		Address a1 = new Address();
		List<Address> a1List = new ArrayList<Address>();
		a1.setAddrId(12L);
		a1.setArea("madinepally");
		a1.setCity("west godavari");
		a1.setPincode(241356);
		a1.setStreet("president colony");
		a1.setState("Andra Pradesh");
		a1List.add(a1);
		
		Customer c11 = new Customer();
		c11.setId(15L);
		c11.setName("sri");
		c11.setEmail("sreejak@gmail.com");
		c11.setDoB(LocalDate.of(1999, 12, 12));
		c11.setContactNo("9953124680");
		c11.setCustOrderEntity(null);
		c11.setAddressEntity(a1List);
		
		Customer c6 = new Customer();
		c6.setId(16L);
		c6.setName("ram");
		c6.setEmail("ram11@gmail.com");
		c6.setDoB(LocalDate.of(1998, 12, 12));
		c6.setContactNo("9953124681");
		c6.setCustOrderEntity(null);
		c6.setAddressEntity(a1List);
		
		List<Customer> oList = new ArrayList<Customer>();
		oList.add(c11);
		oList.add(c6);
		
		Mockito.when(this.customerRepository.findAll()).thenReturn(oList);
		assertThat(this.customerService.getAllCustomers()).isEqualTo(oList);

	}
}
