package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@XmlTransient
@JsonDeserialize(as=StringBasedBody.class)
public interface Body {
	String getBody();
}
