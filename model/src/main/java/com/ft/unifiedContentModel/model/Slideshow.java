package com.ft.unifiedContentModel.model;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonDeserialize(as=SlideshowImpl.class)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public interface Slideshow {

	String getSlideshowHeading();
	List<Image> getSlides();
	
}
