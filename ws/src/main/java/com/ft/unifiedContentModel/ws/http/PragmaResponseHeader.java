package com.ft.unifiedContentModel.ws.http;

import javax.servlet.http.HttpServletResponse;

/**
 * A {@link ResponseHeader} that adds a 'Pragma' header to disable caching of the response.
 * @author Dan
 *
 */
public class PragmaResponseHeader implements ResponseHeader{
	
	protected static final String PRAGMA_HEADER_NAME = "Pragma";
	protected static final String PRAGMA_HEADER_VALUE = "no-cache";

	
	@Override
	public void setOn(HttpServletResponse response) {
		response.addHeader(PRAGMA_HEADER_NAME, PRAGMA_HEADER_VALUE);
	}
}
