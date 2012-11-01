package com.ft.api.ucm.model.v1;


import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class DataTableFields {
	private String body;

	public DataTableFields() {
	}

	public DataTableFields(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
