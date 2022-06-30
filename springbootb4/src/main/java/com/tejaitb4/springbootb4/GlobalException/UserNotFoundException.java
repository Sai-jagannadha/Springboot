package com.tejaitb4.springbootb4.GlobalException;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
@AllArgsConstructor
@Setter
@Getter
public class UserNotFoundException extends RuntimeException{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
