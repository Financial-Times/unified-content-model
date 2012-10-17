package com.ft.unifiedContentModel.core.net;

public class HexHashHelper {
	
	public static <T> String hexHash8(T t){
		return hexHash(t, 8);
	}
	
	public static <T> String hexHash(T t, int numCharacters){
		return String.format("%0"+numCharacters+"x", Integer.valueOf(t.hashCode()));
	}

}
