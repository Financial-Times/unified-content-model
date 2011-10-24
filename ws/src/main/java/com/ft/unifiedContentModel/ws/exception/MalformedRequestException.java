package com.ft.unifiedContentModel.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MalformedRequestException extends RuntimeException{

	private static final long serialVersionUID = 1661861194413746579L;

	private BindingResult bindingResult;

	public MalformedRequestException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	@Override
	public String getMessage() {
		return bindingResult.toString();
    }

}
