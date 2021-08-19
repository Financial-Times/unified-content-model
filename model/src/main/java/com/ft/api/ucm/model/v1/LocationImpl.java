package com.ft.api.ucm.model.v1;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.StringUtils;

public class LocationImpl implements Location {

  private String uri;

  public LocationImpl() {}

  public LocationImpl(String uri) {
    this.uri = StringUtils.isNotBlank(uri) ? uri : null;
  }

  @Override
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri.trim();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("uri", uri).toString();
  }
}
