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
import com.sport.cg.repository.ICardRepository;
import com.sport.cg.service.ICardService;

@SpringBootTest
class TestCardService {
	
	@MockBean
	ICardRepository cardRepository;
	
	@Autowired
	ICardService cardService;

	@Test
	 void testAddCard() {
		Card c = new Card();
		List<Card> a1List = new ArrayList<Card>();
		c.setCardId(123L);
		c.setCardName("visa");
		c.setCardNumber("123456");
		c.setExpiryDate(LocalDate.of(2022, 2, 4));
		c.setBankName("hdfc");
		a1List.add(c);
		
		Mockito.when(cardRepository.save(c)).thenReturn(c);
		Card returned = cardService.addCard(c);
		assertThat(returned).isEqualTo(c);	
	}
	
	@Test
	public void test_removeCard_ThrowCardNotFoundException() {
		Card c1 = new Card();
		//List<Card> a2List = new ArrayList<Card>();
		c1.setCardId(156L);
		c1.setCardName("gold");
		c1.setCardNumber("123695");
		c1.setExpiryDate(LocalDate.of(2022, 2, 8));
		c1.setBankName("Axis");
		//a2List.add(c1);
		
		Optional<Card> ord = Optional.of(c1);
		Mockito.when(cardRepository.findById(156L)).thenReturn(ord);
		Mockito.when(cardRepository.existsById(c1.getCardId())).thenReturn(false);
		assertFalse(cardRepository.existsById(c1.getCardId()));
	
	}
	
	@Test
	public void testUpdateCard() {
		Card c2 = new Card();
		c2.setCardId(535L);
		c2.setCardName("Visa");
		c2.setBankName("HDFC");
		c2.setCardNumber("1625347");
		c2.setExpiryDate(LocalDate.of(2026, 04, 30));
		c2.setCardPaymentEntity(null);
		
		 Optional<Card> o =Optional.of(c2);
	     Mockito.when(cardRepository.findById(535L)).thenReturn(o);
	     c2.setExpiryDate(LocalDate.of(2030, 05, 31));
		 Mockito.when(cardRepository.save(c2)).thenReturn(c2);
		 assertThat(cardService.updateCard(535L, c2)).isEqualTo(c2);
	}
		
	@Test
	public void testGetCard() {
		Card c3 = new Card();
		List<Card> a1List = new ArrayList<Card>();
		c3.setCardId(698L);
		c3.setCardName("visa");
		c3.setCardNumber("123456");
		c3.setExpiryDate(LocalDate.of(2022, 2, 4));
		c3.setBankName("hdfc");
		a1List.add(c3);
		
       Optional<Card> opt = Optional.of(c3);
		Mockito.when(cardRepository.findById(698L)).thenReturn(opt);
	    assertThat(cardService.getCardDetails(698L)).isEqualTo(c3);
	}
	
	

	@Test
	void test_getAllCard() {
		Card c4 = new Card();
		List<Card> a5List = new ArrayList<Card>();
		c4.setCardId(485L);
		c4.setCardName("master");
		c4.setCardNumber("123445");
		c4.setExpiryDate(LocalDate.of(2022, 5, 6));
		c4.setBankName("BOM");
		a5List.add(c4);
		
		List<Card> oList = new ArrayList<Card>();
		oList.add(c4);
		oList.add(c4);
		
		Mockito.when(this.cardRepository.findAll()).thenReturn(oList);
		assertThat(this.cardService.getAllCards()).isEqualTo(oList);
		
	}
}
