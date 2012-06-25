package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=IndexedTypeBasedImage.class)
public interface IndexedImage extends Image {

   Integer getSlideNumber();

}
