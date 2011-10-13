package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface Versionable {

	String getModelVersion();
	
}
