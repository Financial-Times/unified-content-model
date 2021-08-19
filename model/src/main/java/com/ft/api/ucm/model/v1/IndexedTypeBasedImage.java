package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
  "slideNumber",
  "url",
  "type",
  "source",
  "alt",
  "caption",
  "height",
  "width",
  "mediaType"
})
public class IndexedTypeBasedImage implements IndexedImage {

  @JsonUnwrapped
  @JsonDeserialize(as = TypeBasedImage.class)
  private Image typeBasedImage;

  private Integer slideNumber;

  public IndexedTypeBasedImage() {}

  public IndexedTypeBasedImage(Image typeBasedImage, Integer slideNumber) {
    this.typeBasedImage = typeBasedImage;
    this.slideNumber = slideNumber;
  }

  @Override
  public String getUrl() {
    return typeBasedImage.getUrl();
  }

  @Override
  public String getType() {
    return typeBasedImage.getType();
  }

  @Override
  public String getSource() {
    return typeBasedImage.getSource();
  }

  @Override
  public String getAlt() {
    return typeBasedImage.getAlt();
  }

  @Override
  public String getCaption() {
    return typeBasedImage.getCaption();
  }

  @Override
  public Integer getHeight() {
    return typeBasedImage.getHeight();
  }

  @Override
  public Integer getWidth() {
    return typeBasedImage.getWidth();
  }

  @Override
  public String getMediaType() {
    return typeBasedImage.getMediaType();
  }

  @Override
  public Integer getSlideNumber() {
    return slideNumber;
  }
}
