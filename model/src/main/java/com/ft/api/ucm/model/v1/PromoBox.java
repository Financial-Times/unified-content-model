package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class PromoBox implements Asset {

  private String name;
  private PromoBoxFields fields;

  public PromoBoxFields getFields() {
    return fields;
  }

  public void setFields(PromoBoxFields fields) {
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
}
