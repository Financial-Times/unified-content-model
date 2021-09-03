package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "type", "slideshowHeading", "slides"})
public class OldSlideshow implements MediaAsset {

  private String name;
  private String uuid;
  private String slideshowHeading;
  List<IndexedImage> slides;

  public OldSlideshow() {}

  public OldSlideshow(String uuid, String slideshowHeading, List<IndexedImage> slides) {
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
    return MoreObjects.toStringHelper(this)
        .add("slideshowHeading", slideshowHeading)
        .add("slides", slides)
        .add("name", name)
        .toString();
  }
}
