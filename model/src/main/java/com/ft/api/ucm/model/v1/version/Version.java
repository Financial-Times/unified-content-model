package com.ft.api.ucm.model.v1.version;

import com.google.common.collect.Maps;
import java.util.Map;

public enum Version {
  ONE("1");

  private static final Map<String, Version> ENUM_NAMES = Maps.newHashMap();

  static {
    for (Version version : values()) {
      ENUM_NAMES.put(version.toString(), version);
    }
  }

  private String display;

  private Version(String display) {
    this.display = display;
  }

  @Override
  public String toString() {
    return display;
  }

  public Version fromString(String version) {
    return ENUM_NAMES.get(version);
  }
}
