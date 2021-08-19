package com.ft.api.ucm.model.v1;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.StringUtils;

public class SummaryImpl implements Summary {

  private String excerpt;

  public SummaryImpl() {}

  public SummaryImpl(String excerpt) {
    this.excerpt = StringUtils.isNotBlank(excerpt) ? excerpt : null;
  }

  @Override
  public String getExcerpt() {
    return excerpt;
  }

  public void setExcerpt(String excerpt) {
    this.excerpt = excerpt;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("excerpt", excerpt).toString();
  }
}
