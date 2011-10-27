package com.ft.unifiedContentModel.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * An exception for when a service contract was fulfilled but there is no response body or content
 * to return as a result.
 * 
 * @author Gary Watson
 */
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoContentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoContentException() {
	}
}
