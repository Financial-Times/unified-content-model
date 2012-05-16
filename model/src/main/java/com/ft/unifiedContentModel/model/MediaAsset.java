package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type")
    @JsonSubTypes({
           @JsonSubTypes.Type(value=Slideshow.class, name="slideshow")
       })
public interface MediaAsset {
    String getName();
}
