package com.ft.unifiedContentModel.model;

import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"subheading", "leadBody", "standFirst"})
public class EditorialImpl extends AttributionImpl implements Editorial  {
	
	private String subheading;
	private String leadBody;
	private String standFirst;

	public EditorialImpl() {}
	
	public EditorialImpl(String byline, String subheading, String leadBody, String standFirst) {
		super(byline);
		this.subheading = StringUtils.isNotBlank(subheading) ? subheading : null;
		this.leadBody = StringUtils.isNotBlank(leadBody) ? leadBody : null;
		this.standFirst = StringUtils.isNotBlank(standFirst) ? standFirst : null;
	}
	
	@Override
	public String getSubheading() {
		return subheading;
	}

	@Override
	public String getLeadBody() {
		return leadBody;
	}

	@Override
	public String getStandFirst() {
		return standFirst;
	}
	
	public void setSubheading(String subheading) {
		this.subheading = subheading;
	}

	public void setLeadBody(String leadBody) {
		this.leadBody = leadBody;
	}

	public void setStandFirst(String standFirst) {
		this.standFirst = standFirst;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
					.add("byline", getByline())
					.add("subheading", subheading)
					.add("leadBody", leadBody)
					.add("standFirst", standFirst)
					.toString();
	}

}
