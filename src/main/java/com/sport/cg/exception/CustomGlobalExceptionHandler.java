package com.sport.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<String> handleException(AddressNotFoundException addressError){
		return new ResponseEntity<String>(addressError.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(CardNotFoundException cardError){
		return new ResponseEntity<String>(cardError.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(CartNotFoundException cartException){
		return new ResponseEntity<String>(cartException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(CustomerNotFoundException customerError){
		return new ResponseEntity<String>(customerError.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(OrderNotFoundException orderError){
		return new ResponseEntity<String>(orderError.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(PaymentNotFoundException paymentError){
		return new ResponseEntity<String>(paymentError.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(ProductNotFoundException productError){
		return new ResponseEntity<String>(productError.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(UserNotFoundException userError){
		return new ResponseEntity<String>(userError.getMessage(), HttpStatus.NOT_FOUND);
	}
}
