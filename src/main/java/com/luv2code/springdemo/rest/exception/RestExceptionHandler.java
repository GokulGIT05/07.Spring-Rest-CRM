package com.luv2code.springdemo.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> notFoudExc(CustomerNotFoundException exc){
		 
		CustomerErrorResponse response = new CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());
		
		ResponseEntity<CustomerErrorResponse> entity =
					new ResponseEntity<CustomerErrorResponse>(response, HttpStatus.NOT_FOUND);
		
		
		return entity;
	}
	
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> genericExc(Exception exc){
		 
		CustomerErrorResponse response = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());
		
		
		return new ResponseEntity<CustomerErrorResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
