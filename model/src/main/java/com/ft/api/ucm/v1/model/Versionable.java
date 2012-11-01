package com.ft.api.ucm.v1.model;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public interface Versionable {

	String getModelVersion();
	
}
