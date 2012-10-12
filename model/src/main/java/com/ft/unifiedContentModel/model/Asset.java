package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type")
    @JsonSubTypes({
           @JsonSubTypes.Type(value=Slideshow.class, name="slideshow"),
           @JsonSubTypes.Type(value=VideoAsset.class, name="video"),
           @JsonSubTypes.Type(value=PullQuote.class, name="pullQuote"),
           @JsonSubTypes.Type(value=InteractiveGraphic.class, name="interactiveGraphic"),
           @JsonSubTypes.Type(value=BackgroundNews.class, name="backgroundNews"),
           @JsonSubTypes.Type(value=DataTable.class, name="dataTable")
    })
public interface Asset {
    String getName();
    void setName(String name);
}
