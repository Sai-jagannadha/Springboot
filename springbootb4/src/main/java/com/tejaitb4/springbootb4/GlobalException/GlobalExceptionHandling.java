package com.tejaitb4.springbootb4.GlobalException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
//@ExceptionHandler(UserNotFoundException.class)
//	public ResponseEntity<ErrorDetails> userNotAvailableException(UserNotFoundException ex){
//		ErrorDetails error=new ErrorDetails(new Date(),"User Data Not Found","Please Provide Proper Input");
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorDetails> userNotAvailableException(Exception ex){
	ErrorDetails error=new ErrorDetails(new Date(),"Global exception","Global exception Handling");
	return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
}
}
