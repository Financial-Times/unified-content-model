package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class BackgroundNews implements Asset {

  private String name;
  private BackgroundNewsFields fields;

  public BackgroundNews() {}

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  public BackgroundNewsFields getFields() {
    return fields;
  }

  public void setFields(BackgroundNewsFields fields) {
    this.fields = fields;
  }
}
