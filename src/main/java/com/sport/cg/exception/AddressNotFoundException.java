package com.sport.cg.exception;

public class AddressNotFoundException extends RuntimeException{ 
	
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
}
