package com.ft.api.ucm.rest.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>A simple interface to a class representing an HttpServletResponse header</p>
 * 
 * @author andrew.winter
 */
public interface ResponseHeader {
	
	void setOn(HttpServletResponse response, HttpServletRequest request);

}
