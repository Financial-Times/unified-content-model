package com.ft.unifiedContentModel.model;

import java.util.List;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public interface Slideshow {

	String getSlideshowHeading();
	List<Image> getSlides();
	
}
