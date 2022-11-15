package com.example.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandlers extends Exception{
	
	@ExceptionHandler(OrdersException.class)
	public ResponseEntity<ErrorDetails> OrdersExceptionhandler(OrdersException ordersException, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), ordersException.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> OtherExceptionhandler(Exception ordersException, WebRequest req){
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(), ordersException.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}
