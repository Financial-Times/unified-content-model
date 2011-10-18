package com.ft.unifiedContentModel.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MalformedRequestException extends RuntimeException{

	private static final long serialVersionUID = 1661861194413746579L;

}
