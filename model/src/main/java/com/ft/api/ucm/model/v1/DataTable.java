package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class DataTable implements Asset {

  private String name;
  private DataTableFields fields;

  public DataTable() {}

  public DataTable(String name, DataTableFields fields) {
    this.name = name;
    this.fields = fields;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DataTableFields getFields() {
    return fields;
  }

  public void setFields(DataTableFields fields) {
    this.fields = fields;
  }
}
