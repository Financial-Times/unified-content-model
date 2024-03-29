package com.ft.api.ucm.model.v1;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.StringUtils;

public class PackagingImpl implements Packaging {

  private String kicker;
  private String spHeadline;

  public PackagingImpl() {}

  public PackagingImpl(String kicker, String spHeadline) {
    this.kicker = StringUtils.isNotBlank(kicker) ? kicker : null;
    this.spHeadline = StringUtils.isNotBlank(spHeadline) ? spHeadline : null;
  }

  @Override
  public String getKicker() {
    return kicker;
  }

  public void setKicker(String kicker) {
    this.kicker = kicker;
  }

  @Override
  public String getSpHeadline() {
    return spHeadline;
  }

  public void setSpHeadline(String spHeadline) {
    this.spHeadline = spHeadline;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("kicker", kicker)
        .add("spHeadline", spHeadline)
        .toString();
  }
}
