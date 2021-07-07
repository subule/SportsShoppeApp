package com.sport.cg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.Card;
import com.sport.cg.repository.ICardRepository;

@Service
public class CCardService implements ICardService{
	
	static final Logger LOGGER = LoggerFactory.getLogger(CCardService.class);
	
	
	@Autowired
	private ICardRepository cardRepository;
	
	@Override
	public Card addCard(Card card) {
		LOGGER.info("addCard() service is initiated");
		return cardRepository.save(card);
	}

	@Override
	public Card removeCard(long id) {
		LOGGER.info("removeCard() service is initiated");
	    Card deleteCard = cardRepository.findById(id).get();
	    cardRepository.delete(deleteCard);
	    LOGGER.info("removeCard() service has executed");
	    return deleteCard;
	}

	@Override
	public Card updateCard(long id, Card card) {
		LOGGER.info("updateCard() service is initiated");
		Card updateCard = cardRepository.findById(id).get();
		updateCard = cardRepository.save(card);
		LOGGER.info("updateCard() service has executed");
		return updateCard;
	}

	@Override
	public Card getCardDetails(long id) {
		LOGGER.info("getCardDetails() service is initiated");
		Card getCardDetails = cardRepository.findById(id).get();
		LOGGER.info("getCardDetails() service has executed");
		return getCardDetails;
	}

	@Override
	public List<Card> getAllCards() {
		LOGGER.info("getAllCards() service is initiated");
		List<Card> getAllCards = cardRepository.findAll();
		LOGGER.info("getAllCards() service has executed");
		return getAllCards;
	}	


}
