package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

@XmlType(name="location", namespace=XSDs.ASPECT_NAMESPACE)
public class LocationImpl implements Location {

	private String uri;
	
	public LocationImpl(){
	}

	public LocationImpl(String uri) {
		this.uri = StringUtils.isNotBlank(uri) ? uri : null;
	}

	@Override
	@XmlElement(name="uri", namespace=XSDs.FIELD_NAMESPACE)
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri.trim();
	}
	
}
