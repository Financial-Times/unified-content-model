package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = IndexedTypeBasedImage.class)
public interface IndexedImage extends Image {

  Integer getSlideNumber();
}
