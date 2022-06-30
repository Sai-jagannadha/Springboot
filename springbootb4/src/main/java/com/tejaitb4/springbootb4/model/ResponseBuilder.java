package com.tejaitb4.springbootb4.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {
 public ResponseEntity<ApiResponse>buildResponse(
		 HttpHeaders httpHeader,int httpStatusCode,String message,Object data){
	 return new ApiResponse.ApiResponseBuilder<>(httpHeader, httpStatusCode, message, data)
			 .build();
 }
}
