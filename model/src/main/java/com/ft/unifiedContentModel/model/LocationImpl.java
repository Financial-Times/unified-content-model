package com.ft.unifiedContentModel.model;

import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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

    @Override
	public String toString() {
		return Objects.toStringHelper(this).add("uri", uri).toString();
	}
	
}
