package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@XmlTransient
@JsonDeserialize(as=MasterImpl.class)
public interface Master {
	
		String getMasterSource();
		String getMasterEntityId();
		
}
