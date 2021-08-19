package com.ft.api.ucm.model.v1;

public class InteractiveGraphic implements Asset {

  private String name;
  private InteractiveGraphicFields fields;

  public InteractiveGraphicFields getFields() {
    return fields;
  }

  public void setFields(InteractiveGraphicFields fields) {
    this.fields = fields;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
}
