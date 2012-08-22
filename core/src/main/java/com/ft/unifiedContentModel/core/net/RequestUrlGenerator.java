package com.ft.unifiedContentModel.core.net;

public interface RequestUrlGenerator {

    Url createRequestUrl(String servletPath, String pathInfo, String queryString);
	
}
