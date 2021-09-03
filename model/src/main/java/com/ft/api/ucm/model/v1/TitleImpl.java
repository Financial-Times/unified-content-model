package com.ft.api.ucm.model.v1;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.StringUtils;

public class TitleImpl implements Title {

  private String title;

  public TitleImpl() {}

  public TitleImpl(String title) {
    this.title = StringUtils.isNotBlank(title) ? title : null;
  }

  @Override
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("title", title).toString();
  }
}
