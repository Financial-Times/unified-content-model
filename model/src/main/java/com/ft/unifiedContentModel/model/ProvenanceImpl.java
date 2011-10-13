package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Objects;

@XmlType(name="provenance", namespace=XSDs.ASPECT_NAMESPACE)

public class ProvenanceImpl implements Provenance {
	
	private String originatingParty;
	
	public ProvenanceImpl() {}
	
	public ProvenanceImpl(String originatingParty) {
		this.originatingParty = StringUtils.isNotBlank(originatingParty) ? originatingParty : null;
	}

	@Override
	@XmlElement(name="originatingParty", namespace=XSDs.FIELD_NAMESPACE)
	public String getOriginatingParty(){
		return originatingParty;
	}
	
	public void setOriginatingParty(String originatingParty){
		this.originatingParty = originatingParty;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("originatingParty", originatingParty).toString();
	}
}
