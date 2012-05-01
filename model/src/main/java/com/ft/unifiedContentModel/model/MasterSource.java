package com.ft.unifiedContentModel.model;

import com.google.common.collect.Maps;
import java.util.Map;

public enum MasterSource {
	
	METHODE("Methode");
	
	private static final Map<String, MasterSource> ENUM_NAMES = Maps.newHashMap();
	
	static { 
		for (MasterSource masterSource : values()) {
			ENUM_NAMES.put(masterSource.toString(), masterSource);
		}
	}

	public static MasterSource fromString(String displayName) {
		return ENUM_NAMES.get(displayName);
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
