package com.sport.cg.exception;

public class PaymentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PaymentNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
