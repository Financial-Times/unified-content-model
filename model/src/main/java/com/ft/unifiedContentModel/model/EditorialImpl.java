package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Objects;

@XmlType(name="editorial", namespace=XSDs.ASPECT_NAMESPACE, propOrder={"subheading", "leadBody", "standFirst"})
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
	@XmlElement(name="subheading", namespace=XSDs.FIELD_NAMESPACE)
	public String getSubheading() {
		return subheading;
	}

	@Override
	@XmlElement(name="leadBody", namespace=XSDs.FIELD_NAMESPACE)
	public String getLeadBody() {
		return leadBody;
	}

	@Override
	@XmlElement(name="standFirst", namespace=XSDs.FIELD_NAMESPACE)
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
