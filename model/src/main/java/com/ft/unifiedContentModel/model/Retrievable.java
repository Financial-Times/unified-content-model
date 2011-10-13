package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface Retrievable {

	String getApiUrl();
	
	void setApiUrl(String apiUrl);
}
