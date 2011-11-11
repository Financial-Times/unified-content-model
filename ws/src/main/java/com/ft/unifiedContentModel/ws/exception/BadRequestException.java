package com.ft.unifiedContentModel.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 544698564388478760L;

	public BadRequestException(){
		super();
	}
	
	public BadRequestException(Throwable cause){
		super(cause);
	}
}
