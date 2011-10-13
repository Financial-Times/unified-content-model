package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Objects;

@XmlType(name="title", namespace=XSDs.ASPECT_NAMESPACE)
public class TitleImpl implements Title {

	private String title;
	
	public TitleImpl() { 
	}
	
	public TitleImpl(String title) {
		this.title = StringUtils.isNotBlank(title) ? title : null;
	}
	
	@XmlElement(name="title", namespace=XSDs.FIELD_NAMESPACE)
	@Override
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("title", title).toString();
	}

}
