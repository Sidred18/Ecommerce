package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNotFound(ResourceNotFoundException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<String> duplicateResource(DuplicateResourceException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
