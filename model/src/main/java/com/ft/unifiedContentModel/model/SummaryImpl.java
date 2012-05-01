package com.ft.unifiedContentModel.model;

import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;

public class SummaryImpl implements Summary {

	private String excerpt;
	
	public SummaryImpl() {
	}

	public SummaryImpl(String excerpt) {
		this.excerpt = StringUtils.isNotBlank(excerpt) ? excerpt : null;
	}
	
	@Override
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
