package com.tejaitb4.springbootb4.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@JsonPropertyOrder({"httpHeaders","httpStatusCode","message","T data"})
public class ApiResponse<T> {
	private final HttpHeaders httpHeaders;
    private final int httpStatusCode;
    private final String message;
    private final T data;
    
    private ApiResponse(ApiResponseBuilder builder) {
        this.httpHeaders = builder.httpHeaders;
        this.httpStatusCode = builder.httpStatusCode;
        this.message = builder.message;
        this.data = (T) builder.data;
    }
    @AllArgsConstructor
    public static class ApiResponseBuilder<T> {
    	 private HttpHeaders httpHeaders=new HttpHeaders();
    	 private final int httpStatusCode;
    	 private final String message;
    	 private T data;
    	 
    	 public ResponseEntity<ApiResponse>build(){
    		 	ApiResponse<T>apiResponse=new ApiResponse<>(this);
    		 	return ResponseEntity.status(apiResponse.getHttpStatusCode())
    		 			.headers(apiResponse.getHttpHeaders())
    		 			.body(apiResponse);
    		 	
    	 }
    	 
    	 
         }

    
    	
    }
    
    

