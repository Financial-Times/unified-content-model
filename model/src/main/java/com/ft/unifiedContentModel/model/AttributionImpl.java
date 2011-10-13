package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Objects;

@XmlType(name="attribution", namespace=XSDs.ASPECT_NAMESPACE)
public class AttributionImpl implements Attributed {

	private String byline;
	
	public AttributionImpl(){
	}
	
	public AttributionImpl(String byline) {
		this.byline = StringUtils.isNotBlank(byline) ? byline : null;
	}
	
	@Override
	@XmlElement(name="byline", namespace=XSDs.FIELD_NAMESPACE)
	public String getByline() {
		return byline;
	}
	
	public void setByline(String byline) {
		this.byline = byline;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("byline", byline).toString();
	}

}
