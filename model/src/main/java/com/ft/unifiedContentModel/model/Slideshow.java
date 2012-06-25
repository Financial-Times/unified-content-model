package com.ft.unifiedContentModel.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.common.base.Objects;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "slideshowHeading", "slides"})
public class Slideshow implements MediaAsset {

	private String name;
	private String uuid;
	private String slideshowHeading;
	List<IndexedImage> slides;
	
	public Slideshow() {
		
	}
	
	public Slideshow(String uuid, String slideshowHeading, List<IndexedImage> slides) {
		this.uuid = uuid;
		this.slideshowHeading = slideshowHeading;
		this.slides = slides;
	}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getSlideshowHeading() {
		return slideshowHeading;
	}

	public void setSlideshowHeading(String slideshowHeading) {
		this.slideshowHeading = slideshowHeading;
	}

	public List<IndexedImage> getSlides() {
		return slides;
	}
	
	public void setSlides(List<IndexedImage> slides) {
		this.slides = slides;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
						.add("slideshowHeading", slideshowHeading)
						.add("slides", slides)
						.add("name", name)
						.toString();
	}

}
