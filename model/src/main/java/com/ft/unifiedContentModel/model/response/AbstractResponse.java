package com.ft.unifiedContentModel.model.response;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public abstract class AbstractResponse implements Response {
	
	
	private String requestUrl;
	
	public AbstractResponse() {
		// required for JAXB
	}

	@Override
	public String getRequestUrl() {
		return requestUrl;
	}

	@Override
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
}
