package com.sport.cg.testservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sport.cg.entity.Address;
import com.sport.cg.repository.IAddressRepository;
import com.sport.cg.service.IAddressService;

@SpringBootTest
class TestAddressService {

	@MockBean
	IAddressRepository iaddressRepository;
	
	@Autowired
	IAddressService addressServiceImpl;
	
	
	
	@Test
	void testAddAddress() {
		Address a = new Address();
		a.setAddrId(1L);
		a.setArea("Area");
		a.setCity("City");
		a.setPincode(241356);
		a.setStreet("Street");
		a.setState("State");
		a.setCustomerEntity(null);
		
		Mockito.when(iaddressRepository.save(a)).thenReturn(a);
		Address returned=addressServiceImpl.addAddress(a);
		assertThat(returned).isEqualTo(a);
		
	}

	@Test
	void testRemoveAddress() {
		Address a2 = new Address();
		List<Address> a22List = new ArrayList<Address>();
		a2.setAddrId(43L);
		a2.setArea("Area2");
		a2.setCity("Cit2y");
		a2.setPincode(221356);
		a2.setStreet("Street2");
		a2.setState("State2");
		a22List.add(a2);
			
		Optional<Address> ord = Optional.of(a2);
		Mockito.when(iaddressRepository.findById(43L)).thenReturn(ord);
		Mockito.when(iaddressRepository.existsById(a2.getAddrId())).thenReturn(false);
		assertFalse(iaddressRepository.existsById(a2.getAddrId()));
	}

	@Test
	void testUpdateAddress() {
		Address a23 = new Address();
		List<Address> a23List = new ArrayList<Address>();
		a23.setAddrId(433L);
		a23.setArea("Area23");
		a23.setCity("City3");
		a23.setPincode(221336);
		a23.setStreet("Street23");
		a23.setState("State23");
		a23List.add(a23);
				
		 Optional<Address> o =Optional.of(a23);
	     Mockito.when(iaddressRepository.findById(433L)).thenReturn(o);
	     a23.setArea("Area24");
		 Mockito.when(iaddressRepository.save(a23)).thenReturn(a23);
		 assertThat(addressServiceImpl.updateAddress(433L, a23)).isEqualTo(a23);
	}

	@Test
	void testGetAddress() {
		Address a14 = new Address();
		List<Address> a14List = new ArrayList<Address>();
		a14.setAddrId(124L);
		a14.setArea("Area41");
		a14.setCity("City14");
		a14.setPincode(244456);
		a14.setStreet("Street41");
		a14.setState("State14");
		a14List.add(a14);
	
		Optional<Address> opt = Optional.of(a14);
		
		Mockito.when(iaddressRepository.findById(124L)).thenReturn(opt);
	    assertThat(addressServiceImpl.getAddress(124L)).isEqualTo(a14);
	}
}
