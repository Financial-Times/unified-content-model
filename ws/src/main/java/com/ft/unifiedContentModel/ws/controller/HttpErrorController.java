package com.ft.unifiedContentModel.ws.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpErrorController {
	
	@RequestMapping(value = "/errors/{statusCode}")
	public ResponseEntity<String> handleErrorRequest(@PathVariable int statusCode) {
		return new ResponseEntity<String>(StringUtils.EMPTY, HttpStatus.valueOf(statusCode));
	}

	
	
}
