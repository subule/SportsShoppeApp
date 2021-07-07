package com.sport.cg.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.cg.entity.Card;
import com.sport.cg.exception.CardNotFoundException;
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
	    Optional<Card> deleteCard = cardRepository.findById(id);
	    if(deleteCard.isPresent()) {
	    	cardRepository.deleteById(deleteCard.get().getCardId());
	    }
	    else {
	    	throw new CardNotFoundException("Card cannot be found");
	    }
	    
	    LOGGER.info("removeCard() service has executed");
	    return deleteCard.get();
	}

	@Override
	public Card updateCard(long id, Card card) {
		LOGGER.info("updateCard() service is initiated");
		Optional<Card> updateCard = cardRepository.findById(id);
		Card updatedCard = new Card();
		if(updateCard.isPresent()) {
			updatedCard = cardRepository.save(card);
			LOGGER.info("updateCard() service has executed");
			return updatedCard;
		}
		else {
			throw new CardNotFoundException("Card cannot be updated. Card could not be found");
		}
		}

	@Override
	public Card getCardDetails(long id) {
		LOGGER.info("getCardDetails() service is initiated");
		Optional<Card> getCardDetails = cardRepository.findById(id);
		Card getById = new Card();
		if(getCardDetails.isPresent()) {
			getById = getCardDetails.get();
			LOGGER.info("getCardDetails() service has executed");
			return getById;
		}
		else {
			throw new CardNotFoundException("Card not found");
		}
	}

	@Override
	public List<Card> getAllCards() {
		LOGGER.info("getAllCards() service is initiated");
		List<Card> getAllCards = cardRepository.findAll();
		if(getAllCards.isEmpty()) {
			throw new CardNotFoundException("No Cards present");
		}
		else {
		LOGGER.info("getAllCards() service has executed");
		return getAllCards;
		}
	}	


}
