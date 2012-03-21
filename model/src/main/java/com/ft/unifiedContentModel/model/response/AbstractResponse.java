package com.ft.unifiedContentModel.model.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@XmlTransient
@XmlRootElement(name="abstractResponse")
@XmlSeeAlso({ItemResponse.class, ItemsResponse.class})
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public abstract class AbstractResponse implements Response {
	
	
	private String requestUrl;
	
	public AbstractResponse() {
		// required for JAXB
	}

	@XmlAttribute
	@Override
	public String getRequestUrl() {
		return requestUrl;
	}

	@Override
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
}
