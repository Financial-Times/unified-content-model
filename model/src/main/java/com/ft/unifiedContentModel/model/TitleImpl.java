package com.ft.unifiedContentModel.model;

import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;


public class TitleImpl implements Title {

	private String title;
	
	public TitleImpl() { 
	}
	
	public TitleImpl(String title) {
		this.title = StringUtils.isNotBlank(title) ? title : null;
	}

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
