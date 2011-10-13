package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Objects;

@XmlType(name="packaging", namespace=XSDs.ASPECT_NAMESPACE , propOrder={"kicker", "spHeadline"})
public class PackagingImpl implements Packaging {

	private String kicker;
	private String spHeadline;
	
	public PackagingImpl() {
	}
	
	public PackagingImpl(String kicker, String spHeadline) {
		this.kicker = StringUtils.isNotBlank(kicker) ? kicker : null;
		this.spHeadline = StringUtils.isNotBlank(spHeadline) ? spHeadline : null;
	}
	
	@Override
	@XmlElement(name="kicker", namespace=XSDs.FIELD_NAMESPACE)
	public String getKicker() {
		return kicker;
	}
	
	public void setKicker(String kicker) {
		this.kicker = kicker;
	}
	
	@Override
	@XmlElement(name="spHeadline", namespace=XSDs.FIELD_NAMESPACE)
	public String getSpHeadline() {
		return spHeadline;
	}
	
	public void setSpHeadline(String spHeadline) {
		this.spHeadline = spHeadline;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
					.add("kicker", kicker)
					.add("spHeadline", spHeadline)
					.toString();
	}
	
}
