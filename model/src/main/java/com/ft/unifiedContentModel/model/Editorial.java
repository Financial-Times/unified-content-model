package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@XmlTransient
@JsonDeserialize(as=EditorialImpl.class)
public interface Editorial extends Attributed {

	String getSubheading();
	String getLeadBody();
	String getStandFirst();
	
}
