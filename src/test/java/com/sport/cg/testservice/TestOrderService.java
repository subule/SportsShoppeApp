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
import com.sport.cg.entity.Orders;
import com.sport.cg.repository.IOrderRepository;
import com.sport.cg.service.IOrderService;

@SpringBootTest //check this annotation
class TestOrderService {
	
	@MockBean
	IOrderRepository orderRepository;
	
	@Autowired
	IOrderService orderService;
	
	@Test
	void testAddOrder(){
		Address a = new Address();
		List<Address> aList = new ArrayList<Address>();
		a.setAddrId(1L);
		a.setArea("Area");
		a.setCity("City");
		a.setPincode(241356);
		a.setStreet("Street");
		a.setState("State");
		aList.add(a);
		
		Customer c1 = new Customer();
		c1.setId(12L);
		c1.setName("Name");
		c1.setEmail("email@email.com");
		c1.setDoB(LocalDate.of(1999, 12, 12));
		c1.setContactNo("9753124680");
		c1.setAddressEntity(aList);
		
		Orders o1 = new Orders();
		o1.setOrderId(55L);
		o1.setPaymentMethod("Card");
		o1.setAmount(250D);
		o1.setBillingDate(LocalDate.now());
		o1.setPaymentEntity(null);
		o1.seteCustomers(c1);
		o1.setEproductEntity(null);
		
		Mockito.when(orderRepository.save(o1)).thenReturn(o1); // Mackito is a class
		Orders returned = orderService.addOrder(o1);
		assertThat(returned).isEqualTo(o1);
	}

	@Test
	void testRemoveOrder() {
		Address a2 = new Address();
		List<Address> a22List = new ArrayList<Address>();
		a2.setAddrId(43L);
		a2.setArea("Area2");
		a2.setCity("Cit2y");
		a2.setPincode(221356);
		a2.setStreet("Street2");
		a2.setState("State2");
		a22List.add(a2);
		
		Customer c122 = new Customer();
		c122.setId(1222L);
		c122.setName("Name2");
		c122.setEmail("email@email.com");
		c122.setDoB(LocalDate.of(1992, 12, 22));
		c122.setContactNo("9752224680");
		c122.setAddressEntity(a22List);
		
		Orders o21 = new Orders();
		o21.setOrderId(55L);
		o21.setPaymentMethod("Card");
		o21.setAmount(250D);
		o21.setBillingDate(LocalDate.now());
		o21.setPaymentEntity(null);
		o21.seteCustomers(c122);
		o21.setEproductEntity(null);
		
		Optional<Orders> ord = Optional.of(o21);
		Mockito.when(orderRepository.findById(55L)).thenReturn(ord);
		Mockito.when(orderRepository.existsById(o21.getOrderId())).thenReturn(false);
		assertFalse(orderRepository.existsById(o21.getOrderId()));
		
	}

	@Test
	void testUpdateOrder() {
		Address a23 = new Address();
		List<Address> a23List = new ArrayList<Address>();
		a23.setAddrId(433L);
		a23.setArea("Area23");
		a23.setCity("City3");
		a23.setPincode(221336);
		a23.setStreet("Street23");
		a23.setState("State23");
		a23List.add(a23);
		
		Customer c23 = new Customer();
		c23.setId(132L);
		c23.setName("Name23");
		c23.setEmail("ema3il@email.com");
		c23.setDoB(LocalDate.of(1989, 12, 23));
		c23.setContactNo("9733224680");
		c23.setAddressEntity(a23List);
		
		Orders o23 = new Orders();
		o23.setOrderId(535L);
		o23.setPaymentMethod("Card");
		o23.setAmount(250D);
		o23.setBillingDate(LocalDate.now());
		o23.setPaymentEntity(null);
		o23.seteCustomers(c23);
		o23.setEproductEntity(null);
		
		 Optional<Orders> o =Optional.of(o23);
	     Mockito.when(orderRepository.findById(535L)).thenReturn(o);
	     o23.setAmount(7490D);
		 Mockito.when(orderRepository.save(o23)).thenReturn(o23);
		 assertThat(orderService.updateOrder(o23.getOrderId(), o23)).isEqualTo(o23);
	}

	@Test
	void testGetOrderDetails() {	
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
		c141.setAddressEntity(a14List);
		
		Orders o14 = new Orders();
		o14.setOrderId(41L);
		o14.setPaymentMethod("Card");
		o14.setAmount(250D);
		o14.setBillingDate(LocalDate.now());
		o14.setPaymentEntity(null);
		o14.seteCustomers(c141);
		o14.setEproductEntity(null);
		
		Optional<Orders> opt = Optional.of(o14);
		
		Mockito.when(orderRepository.findById(41L)).thenReturn(opt);
	    assertThat(orderService.getOrderDetails(41L)).isEqualTo(o14);
	}

	@Test
	void testGetAllOrders() {		
		Address a1 = new Address();
		List<Address> a1List = new ArrayList<Address>();
		a1.setAddrId(12L);
		a1.setArea("Area1");
		a1.setCity("City1");
		a1.setPincode(241356);
		a1.setStreet("Street1");
		a1.setState("State1");
		a1List.add(a1);
		
		Customer c11 = new Customer();
		c11.setId(121L);
		c11.setName("Name1");
		c11.setEmail("email1@email.com");
		c11.setDoB(LocalDate.of(1999, 12, 12));
		c11.setContactNo("9953124680");
		c11.setAddressEntity(a1List);
		
		Orders o11 = new Orders();
		o11.setOrderId(551L);
		o11.setPaymentMethod("Card");
		o11.setAmount(250D);
		o11.setBillingDate(LocalDate.now());
		o11.setPaymentEntity(null);
		o11.seteCustomers(c11);
		o11.setEproductEntity(null);
		
		Orders o121 = new Orders();
		o121.setOrderId(5251L);
		o121.setPaymentMethod("Card");
		o121.setAmount(250D);
		o121.setBillingDate(LocalDate.now());
		o121.setPaymentEntity(null);
		o121.seteCustomers(c11);
		o121.setEproductEntity(null);
		
		List<Orders> oList = new ArrayList<Orders>();
		oList.add(o11);
		oList.add(o121);
		
		Mockito.when(this.orderRepository.findAll()).thenReturn(oList);
		assertThat(this.orderService.getAllOrders()).isEqualTo(oList);

	}

}
