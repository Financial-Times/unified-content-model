package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@XmlTransient
@JsonDeserialize(as=PackagingImpl.class)
public interface Packaging {
	
	String getKicker();
	String getSpHeadline();

}
