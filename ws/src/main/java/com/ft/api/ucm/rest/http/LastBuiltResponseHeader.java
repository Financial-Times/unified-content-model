package com.ft.api.ucm.rest.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ft.unifiedContentModel.core.datetime.Clock;
import com.ft.unifiedContentModel.core.datetime.SystemClock;

/**
 * <p>A ResponseHeader that configures a custom 'X-Last-Built' header to be added
 * to the response, specifying the time that content was fetched.</p>
 */
public class LastBuiltResponseHeader implements ResponseHeader {

	static final String LAST_BUILT_HEADER_NAME = "X-Last-Built";
	
	private final Clock clock;
	
	public LastBuiltResponseHeader() {
		this.clock = new SystemClock();
	}
	
	public LastBuiltResponseHeader(Clock clock) {
		this.clock = clock;
	}
	
	@Override
	public void setOn(HttpServletResponse response, HttpServletRequest request) {
		response.addHeader(LAST_BUILT_HEADER_NAME, clock.toString());
	}
	
}
