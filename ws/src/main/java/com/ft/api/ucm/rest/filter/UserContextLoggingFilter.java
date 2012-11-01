package com.ft.api.ucm.rest.filter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.Log4jNestedDiagnosticContextFilter;

public class UserContextLoggingFilter extends Log4jNestedDiagnosticContextFilter {

	public static final String API_KEY_HEADER = "X-Api-Key";
	public static final String USER_IP_HEADER = "X-Forwarded-For"; 
	
	protected static final String API_KEY_LABEL = "apiKey";
	protected static final String USER_IP_LABEL = "IP";
	
	@Override
	protected String createMessage(HttpServletRequest request, String prefix,
			String suffix) {
		StringBuffer msg = new StringBuffer();
		msg.append(prefix);
		msg.append(getCurrentLoggingContext(request));
		msg.append(suffix);
		return msg.toString();
	}

	private String getCurrentLoggingContext(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String apikey = httpRequest.getHeader(API_KEY_HEADER);
		String ip = httpRequest.getHeader(USER_IP_HEADER);
		
		StringBuffer sb = new StringBuffer();
		if(!StringUtils.isBlank(apikey)) {
			sb.append(API_KEY_LABEL).append("=").append(apikey);
			sb.append(" ");
		}
		
		sb.append(USER_IP_LABEL).append("=");
		if(!StringUtils.isBlank(ip)) {
			sb.append(ip);
		}
		else {
			sb.append(httpRequest.getRemoteAddr());
		}
		
		return sb.toString();
	}
}