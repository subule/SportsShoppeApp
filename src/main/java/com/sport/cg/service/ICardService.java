package com.sport.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sport.cg.entity.Card;

@Service
public interface ICardService {
	
	public Card addCard(Card card);
	public Card removeCard(long id);
	public Card updateCard(long id, Card card);
	public Card getCardDetails(long id);
	public List<Card> getAllCards();
}
