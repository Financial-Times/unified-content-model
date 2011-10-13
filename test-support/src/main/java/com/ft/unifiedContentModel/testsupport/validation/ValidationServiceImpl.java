package com.ft.unifiedContentModel.testsupport.validation;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.springframework.util.Assert;



public class ValidationServiceImpl implements ValidationService {
	
	private Map<String, ResponseValidator> validators;
	
	@Override
	public boolean isValid(String text, String type){
		return isValid(new BufferedInputStream(new ByteArrayInputStream(text.getBytes())), type);
	}
	
	@Override
	public boolean isValid(InputStream text, String type){
		ResponseValidator validator = validators.get(type);
		Assert.notNull(validator,"request type not recognised: "+type);
		return validator.isValid(text);
	}

	public void setValidators(Map<String, ResponseValidator> validators) {
		this.validators = validators;
	}	
	
}
