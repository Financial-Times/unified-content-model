package com.ft.unifiedContentModel.ws.http;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.ft.unifiedContentModel.core.datetime.DateTimeFormatter;


import static com.ft.unifiedContentModel.core.datetime.DateTimes.now;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

/**
 * <p>A ResponseHeader that configures a custom 'X-Last-Built' header to be added
 * to the response, specifying the time that content was fetched.</p>
 * 
 * @author andrew.winter
 */
public class LastBuiltResponseHeader implements ResponseHeader {

	static final String LAST_BUILT_HEADER_NAME = "X-Last-Built";
	
	private DateTimeFormatter dateTimeFormatter;
	private String fixedLastBuiltDateTime = null;
	
	public LastBuiltResponseHeader(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
	/** Override the value of the custom Last Built header, to always return the same value.  */
	public void setFixedLastBuiltDateTime(DateTime fixedLastBuiltDateTime) {
		this.fixedLastBuiltDateTime = dateTimeFormatter.format(fixedLastBuiltDateTime);
	}
	
	@Override
	public void setOn(HttpServletResponse response) {
		response.addHeader(LAST_BUILT_HEADER_NAME, isNotEmpty(fixedLastBuiltDateTime) ? fixedLastBuiltDateTime : dateTimeFormatter.format(now()));
	}
	
}
