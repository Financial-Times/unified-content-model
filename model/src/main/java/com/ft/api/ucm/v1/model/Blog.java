package com.ft.api.ucm.v1.model;

import java.util.List;

public interface Blog {

	String getId();
	
	Title getTitle();
	
	Lifecycle getLifecycle();
	
	Location getLocation();
	
	Master getMaster();

	Packaging getPackaging();

	Body getBody();

	Summary getSummary();

	Metadata getMetadata();

	List<ContentPackageEntry> getPackage();
	
	List<Image> getImages();
	
	
	
}