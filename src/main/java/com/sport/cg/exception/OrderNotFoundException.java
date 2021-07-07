package com.sport.cg.exception;

public class OrderNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public OrderNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
