package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Category {
  ARTICLE("article"),
  BLOGPOST("blogPost"),
  HOMEPAGE("homePage"),
  PODCAST("podcast"),
  OTHERPAGE("otherPage"),
  SECTIONPAGE("sectionPage"),
  SLIDESHOW("slideshow"),
  SPECIALREPORT("specialReport"),
  VIDEO("video");

  private String displayName;

  private Category(String name) {
    this.displayName = name;
  }

  @JsonValue
  public String getDisplayName() {
    return this.displayName;
  }

  @JsonCreator
  public static Category getByDisplayName(String name) {
    for (Category category : Category.values()) {
      if (category.getDisplayName().equals(name)) {
        return category;
      }
    }
    return null;
  }
}
