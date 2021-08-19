package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = TypeBasedImage.class)
public interface Image {

  String getUrl();

  String getType();

  String getSource();

  String getAlt();

  String getCaption();

  Integer getHeight();

  Integer getWidth();

  String getMediaType();
}
