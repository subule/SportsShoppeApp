package com.sport.cg.exception;

public class CartNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CartNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
