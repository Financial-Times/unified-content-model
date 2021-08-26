package com.ft.api.ucm.model.v1;

import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;

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
    return Objects.toStringHelper(this).add("byline", byline).toString();
  }
}
