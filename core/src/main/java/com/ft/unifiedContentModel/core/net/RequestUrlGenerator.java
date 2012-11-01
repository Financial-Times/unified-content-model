package com.ft.unifiedContentModel.core.net;

public interface RequestUrlGenerator {

    String createRequestUrl(String servletPath, String pathInfo, String queryString);
	
}
