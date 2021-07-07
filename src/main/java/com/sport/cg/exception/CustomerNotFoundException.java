package com.sport.cg.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
