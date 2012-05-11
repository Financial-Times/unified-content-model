package com.ft.unifiedContentModel.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.common.base.Objects;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"slideshowHeading", "slides"})
public class SlideshowImpl implements Slideshow {

	String slideshowHeading;
	List<Image> slides;
	
	public SlideshowImpl() {
		
	}
	
	public SlideshowImpl(String slideshowHeading, List<Image> slides) {
		this.slideshowHeading = slideshowHeading;
		this.slides = slides;
	}
	
	
	@Override
	public String getSlideshowHeading() {
		return slideshowHeading;
	}

	public void setSlideshowHeading(String slideshowHeading) {
		this.slideshowHeading = slideshowHeading;
	}
	
	@Override
	public List<Image> getSlides() {
		return slides;
	}
	
	public void setSlides(List<Image> slides) {
		this.slides = slides;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
						.add("slideshowHeading", slideshowHeading)
						.add("slides", slides)
						.toString();
	}

}
