package com.Ankit.blog.exceptions;

import com.Ankit.blog.repo.UserRepo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFundException extends RuntimeException {
	
	
	String resourceName;
	String fieldName;
	long fieldvalue;
	public ResourceNotFundException(String resourceName, String fieldName, long fieldvalue) {
		super(String.format("source not found ",resourceName,fieldName,fieldvalue ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
	

}
