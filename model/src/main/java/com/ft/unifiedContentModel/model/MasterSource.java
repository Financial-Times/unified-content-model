package com.ft.unifiedContentModel.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlType;

import com.google.common.collect.Maps;

@XmlType(namespace=XSDs.CONTENTITEM_NAMESPACE)
public enum MasterSource {
	
	METHODE("Methode");
	
	private static final Map<String, MasterSource> stringToEnum = Maps.newHashMap();
	
	static { 
		for (MasterSource masterSource : values()) {
			stringToEnum.put(masterSource.toString(), masterSource);
		}
	}

	public static MasterSource fromString(String displayName) {
		return stringToEnum.get(displayName);
	}
	
	private String displayName;
	
	private MasterSource(String displayName) {
		this.displayName = displayName;
	}
	
	@Override
	public String toString() {
		return displayName;
	}
}
