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

import com.sport.cg.entity.Card;
import com.sport.cg.entity.Payment;
import com.sport.cg.repository.IPaymentRepository;
import com.sport.cg.service.IPaymentService;

@SpringBootTest
class TestPaymentService {

	@MockBean
	IPaymentRepository paymentRepository;

	@Autowired
	IPaymentService paymentService;
	
	@Test
	 void testAddPayment() {
			
			Card c = new Card();
			List<Card> a1List = new ArrayList<Card>();
			c.setCardId(123L);
			c.setCardName("visa");
			c.setCardNumber("123456");
			c.setExpiryDate(LocalDate.of(2022, 2, 4));
			c.setBankName("hdfc");
			a1List.add(c);
			
			Payment p = new Payment(); 
			p.setPaymentId(1L);
			p.setType("Card");
			p.setStatus("Successfull");

			Mockito.when(paymentRepository.save(p)).thenReturn(p);
			Payment returned = paymentService.addPayment(p);
			assertThat(returned).isEqualTo(p);
	}
	
	@Test
	void testremovePayment() {

		Card c1 = new Card();
		List<Card> a2List = new ArrayList<Card>();
		c1.setCardId(236L);
		c1.setCardName("visa");
		c1.setCardNumber("23654");
		c1.setExpiryDate(LocalDate.of(2022, 4, 6));
		c1.setBankName("BOM");
		a2List.add(c1);
		
		Payment p1 = new Payment(); 
		p1.setPaymentId(2L);
		p1.setType("Card");
		p1.setStatus("Successfull");
		
		Optional<Payment> pay = Optional.of(p1);
		Mockito.when( paymentRepository.findById(2L)).thenReturn(pay);
		Mockito.when( paymentRepository.existsById(p1.getPaymentId())).thenReturn(false);
		assertFalse( paymentRepository.existsById(p1.getPaymentId()));
		
	}
	
	@Test
	void testupdatePayment() {

		Card c2 = new Card();
		List<Card> a3List = new ArrayList<Card>();
		c2.setCardId(245L);
		c2.setCardName("Master");
		c2.setCardNumber("23456");
		c2.setExpiryDate(LocalDate.of(2022, 6, 5));
		c2.setBankName("Axis");
		a3List.add(c2);
		
		Payment p2 = new Payment(); 
		p2.setPaymentId(256L);
		p2.setType("Card");
		p2.setStatus("Successfull");

		 Optional<Payment> pa = Optional.of(p2);
	     Mockito.when(paymentRepository.findById(256L)).thenReturn(pa);
	     p2.setPaymentId(268L);
		 Mockito.when(paymentRepository.save(p2)).thenReturn(p2);
		 assertThat(paymentService.updatePayment(256L, p2)).isEqualTo(p2); //HAD WRITTEN p2.getPaymentId, WHICH WILL 
		 																	//SEARCH FOR 268l AND NOT 256L, AND HENCE THROW EXCEPTION
	}
	
	@Test
	void testGetPayment() {
		
		Card c3 = new Card();
		List<Card> a4List = new ArrayList<Card>();
		c3.setCardId(245L);
		c3.setCardName("Master");
		c3.setCardNumber("23456");
		c3.setExpiryDate(LocalDate.of(2022, 6, 5));
		c3.setBankName("Axis");
		a4List.add(c3);
		
		Payment p3 = new Payment(); 
		p3.setPaymentId(2L);
		p3.setType("Card");
		p3.setStatus("Successfull");
		
        Optional<Payment> pam = Optional.of(p3);
		Mockito.when(paymentRepository.findById(245L)).thenReturn(pam);
	    assertThat(paymentService.getPayment(245L)).isEqualTo(p3);
	}
	
	@Test
	void testgetAllPaymentDetails() {
	
	Card c4 = new Card();
	List<Card> a5List = new ArrayList<Card>();
	c4.setCardId(245L);
	c4.setCardName("Master");
	c4.setCardNumber("23456");
	c4.setExpiryDate(LocalDate.of(2022, 6, 5));
	c4.setBankName("Axis");
	a5List.add(c4);
	
	Payment p4 = new Payment(); 
	p4.setPaymentId(2L);
	p4.setType("Card");
	p4.setStatus("Successfull");
	
	List<Payment> oList = new ArrayList<Payment>();
	oList.add(p4);
	oList.add(p4);
	
	Mockito.when(this.paymentRepository.findAll()).thenReturn(oList);
	assertThat(this.paymentService.getAllPaymentDetails()).isEqualTo(oList);

}
}
