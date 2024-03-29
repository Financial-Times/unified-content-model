package com.ft.api.ucm.model.v1;

import com.google.common.base.MoreObjects;

public class NatureImpl implements Nature {

  private Category category;

  public NatureImpl() {}

  public NatureImpl(Category category) {
    this.category = category;
  }

  @Override
  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("category", category).toString();
  }
}
