package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type")
    @JsonSubTypes({
           @JsonSubTypes.Type(value=Slideshow.class, name="slideshow")
    })
public interface Asset {
    String getName();
    void setName(String name);
    
    @JsonIgnore //we use uuid as key to index mediaAssets before the body has been processed
    String getUuid();

}
