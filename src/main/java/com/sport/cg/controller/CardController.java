package com.sport.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.cg.entity.Card;
import com.sport.cg.service.ICardService;


@RestController
@RequestMapping("/cardcontroller")
public class CardController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);
	@Autowired
	ICardService cardService;


	@PostMapping("/addedCard")
	public ResponseEntity<Card> addCard(@Validated @RequestBody Card card) {
		LOGGER.info("Called POST mapping addCard() method");
		return new ResponseEntity<>(cardService.addCard(card), HttpStatus.CREATED);
	}

	
	@DeleteMapping("/removedCard/{id}")
	public ResponseEntity<Card> removeCard(@PathVariable Long id)  {
		LOGGER.info("Called DELETE mapping removeCard() method");
		return new ResponseEntity<Card>(cardService.removeCard(id), HttpStatus.OK);

	}
	
	
	@PutMapping("/updatedCard/{id}")
	public ResponseEntity<Card> updateCard(@PathVariable long id, @Validated @RequestBody Card card) {
		LOGGER.info("Called PUT mapping updateCard() method");
		Card updatable = cardService.updateCard(id, card);
		return new ResponseEntity<Card>(updatable, HttpStatus.ACCEPTED);

	}

	
	@GetMapping("cardById/{id}")
	public ResponseEntity<Card> getCard(@PathVariable long id) {
		LOGGER.info("Called GET mapping addCard() method");
		return new ResponseEntity<Card>(cardService.getCardDetails(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Card>> getAllCard() {
		LOGGER.info("Called GET mapping addAllCard() method");
		List<Card> allCard = cardService.getAllCards();
		ResponseEntity<List<Card>> entity = new ResponseEntity<List<Card>>(allCard, HttpStatus.OK);
		return entity;
	}


}
