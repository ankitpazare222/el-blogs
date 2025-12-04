package com.Ankit.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Ankit.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundhandler(ResourceNotFundException ex){
		String message=ex.getMessage();
		ApiResponse api=new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>( api ,HttpStatus.NOT_FOUND);
		
	}

}
