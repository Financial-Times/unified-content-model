package com.ft.api.ucm.core.net;

import javax.servlet.http.HttpServletRequest;

public class HttpProtocolResolver {

    private static final String HEADER_PROTOCOL_KEY = "X-Forwarded-Proto";

    public HttpProtocol getProtocol(HttpServletRequest httpServletRequest) {
        String protocol  = httpServletRequest.getHeader(HEADER_PROTOCOL_KEY);
        return getProtocol(protocol);
    }
    
    public HttpProtocol getProtocol(String protocol) {
    	if(protocol == null) {
    		return HttpProtocol.HTTP;
    	}
        HttpProtocol httpProtocol = HttpProtocol.fromString(protocol);
        return httpProtocol == null ? HttpProtocol.HTTP : httpProtocol;
    }
}
