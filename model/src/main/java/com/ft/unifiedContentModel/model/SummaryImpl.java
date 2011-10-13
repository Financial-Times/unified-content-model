package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Objects;

@XmlType(name="summary", namespace=XSDs.ASPECT_NAMESPACE)
public class SummaryImpl implements Summary {

	private String excerpt;
	
	public SummaryImpl() {
	}

	public SummaryImpl(String excerpt) {
		this.excerpt = StringUtils.isNotBlank(excerpt) ? excerpt : null;
	}
	
	@Override
	@XmlElement(name="excerpt", namespace=XSDs.FIELD_NAMESPACE)
	public String getExcerpt() {
		return excerpt;
	}
	
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("excerpt", excerpt).toString();
	}

}
