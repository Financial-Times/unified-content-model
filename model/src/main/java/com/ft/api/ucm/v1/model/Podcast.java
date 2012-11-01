package com.ft.api.ucm.v1.model;

public interface Podcast {
	
	String getId();
	
	Title getTitle();
	
	Lifecycle getLifecycle();
	
	Location getLocation();
	
	Master getMaster();

}
