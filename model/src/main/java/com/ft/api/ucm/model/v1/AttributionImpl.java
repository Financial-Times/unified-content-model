package com.ft.api.ucm.model.v1;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.StringUtils;

public class AttributionImpl implements Attributed {

  private String byline;

  public AttributionImpl() {}

  public AttributionImpl(String byline) {
    this.byline = StringUtils.isNotBlank(byline) ? byline : null;
  }

  @Override
  public String getByline() {
    return byline;
  }

  public void setByline(String byline) {
    this.byline = byline;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("byline", byline).toString();
  }
}
