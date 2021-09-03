package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"title", "slides"})
public class SlideshowFields {

  private String title;
  private List<IndexedImage> slides;

  public SlideshowFields() {}

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
