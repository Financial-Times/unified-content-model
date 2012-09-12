package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type")
    @JsonSubTypes({
           @JsonSubTypes.Type(value=Slideshow.class, name="slideshow"),
           @JsonSubTypes.Type(value=Video.class, name="video")
    })
public interface Asset {
    String getName();
    void setName(String name);
}
