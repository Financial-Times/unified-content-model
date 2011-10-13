package com.ft.unifiedContentModel.model.version;

import java.util.Map;

import com.google.common.collect.Maps;

public enum Version {
	
	ONE("1");
	
	private static final Map<String, Version> stringToEnum = Maps.newHashMap();
	
	static { 
		for (Version version : values()) {
			stringToEnum.put(version.toString(), version);
		}
	}
	
	private String display;
	
	private Version(String display) {
		this.display = display;
	}	
	
	@Override
	public String toString() {
		return display;
	}
	
	public Version fromString(String version) {
		return stringToEnum.get(version);
	}
}

