package com.ft.unifiedContentModel.ws.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A {@link ResponseHeader} that adds a 'Cache-Control' header to disable caching of the response.
 * @author Dan
 *
 */
public class CacheControlResponseHeader implements ResponseHeader {
	
	protected static final String CACHE_CONTROL_HEADER_NAME = "Cache-Control";
	protected static final String CACHE_CONTROL_HEDAER_VALUE = "no-cache, no-store, max-age=0";

	@Override
	public void setOn(HttpServletResponse response, HttpServletRequest request) {
		response.addHeader(CACHE_CONTROL_HEADER_NAME, CACHE_CONTROL_HEDAER_VALUE);
	}

}
