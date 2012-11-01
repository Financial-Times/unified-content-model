package com.ft.api.ucm.rest.http;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.httpclient.util.DateUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * A {@link ResponseHeader} that adds an 'Expires' response header which
 * must be in RFC1123 format as specified in http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.21
 * @author Dan
 *
 */
public class ExpiresResponseHeader implements ResponseHeader{
	
	protected static final String EXPIRES_HEADER_NAME = "Expires";
	
	@Override
	public void setOn(HttpServletResponse response, HttpServletRequest request) {
		String expiryDate = getExpiryDate();
		
		response.addHeader(EXPIRES_HEADER_NAME, expiryDate);
	}

	protected String getExpiryDate() {
		Date now = new Date();
		return DateUtil.formatDate(now, DateUtil.PATTERN_RFC1123);
	}

}
