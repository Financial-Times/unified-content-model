package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class Slideshow implements Asset {

  private String name;
  private SlideshowFields fields;
  private String uuid;

  public Slideshow() {}

  public Slideshow(String uuid, SlideshowFields fields) {
    this.uuid = uuid;
    this.fields = fields;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  public String getUuid() {
    return uuid;
  }

  public SlideshowFields getFields() {
    return fields;
  }

  public void setFields(SlideshowFields fields) {
    this.fields = fields;
  }
}
