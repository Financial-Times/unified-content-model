package com.ft.api.ucm.model.v1;

import java.util.List;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"title", "slides"})
public class SlideshowFields {

	private String title;
	private List<IndexedImage> slides;

	public SlideshowFields() {
	}

	public SlideshowFields(String title, List<IndexedImage> slides) {
		this.title = title;
		this.slides = slides;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<IndexedImage> getSlides() {
		return slides;
	}

	public void setSlides(List<IndexedImage> slides) {
		this.slides = slides;
	}
}
