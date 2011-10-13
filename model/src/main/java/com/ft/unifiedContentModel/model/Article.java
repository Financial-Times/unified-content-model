package com.ft.unifiedContentModel.model;

import java.util.List;

public interface Article {

	Editorial getEditorial();

	Provenance getProvenance();
	
	Location getLocation();
	
	Master getMaster();

	Packaging getPackaging();

	Body getBody();

	Summary getSummary();

	Metadata getMetadata();

	List<ContentPackageEntry> getPackage();
	
	List<Image> getImages();
}