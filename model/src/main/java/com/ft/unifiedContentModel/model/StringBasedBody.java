package com.ft.unifiedContentModel.model;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import com.google.common.base.Objects;

public class StringBasedBody implements Body {

	private String body;

	public StringBasedBody(){
	}
	
	public StringBasedBody(String body) {
		this.body = isNotBlank(body) ? body : null;
	}

	@Override
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public boolean equals(Object that) {
		if (!(that instanceof StringBasedBody)) {
			return false;
		}
		StringBasedBody thatBody = (StringBasedBody) that;
		return body.equals(thatBody.toString());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(body);
	}
	
	@Override
	public String toString() {
		return body;
	}
	
}
