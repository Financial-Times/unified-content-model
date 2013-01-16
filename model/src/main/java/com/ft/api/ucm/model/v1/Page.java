package com.ft.api.ucm.model.v1;

import java.util.List;

public interface Page {

	String getId();
	
	Title getTitle();
	
	Lifecycle getLifecycle();
	
	Location getLocation();

	Summary getSummary();

	Metadata getMetadata();
	
	List<Image> getImages();
	
	Master getMaster();

}
