package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class NumbersComponent implements Asset {

  private String name;
  private NumbersComponentFields fields;

  public NumbersComponentFields getFields() {
    return fields;
  }

  public void setFields(NumbersComponentFields fields) {
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
