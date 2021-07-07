package com.sport.cg.exception;

public class CardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CardNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
