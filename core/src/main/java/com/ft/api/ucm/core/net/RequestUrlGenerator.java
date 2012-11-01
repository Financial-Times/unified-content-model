package com.ft.api.ucm.core.net;

public interface RequestUrlGenerator {

    String createRequestUrl(String servletPath, String pathInfo, String queryString);
	
}
