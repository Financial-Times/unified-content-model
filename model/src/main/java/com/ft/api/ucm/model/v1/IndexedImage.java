package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=IndexedTypeBasedImage.class)
public interface IndexedImage extends Image {

   Integer getSlideNumber();

}
