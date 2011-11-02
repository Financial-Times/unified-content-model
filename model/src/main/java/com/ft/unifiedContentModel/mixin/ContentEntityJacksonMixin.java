package com.ft.unifiedContentModel.mixin;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import com.ft.unifiedContentModel.model.ArticleEntity;
import com.ft.unifiedContentModel.model.BlogEntity;


@JsonTypeInfo(use=Id.NAME, include=As.PROPERTY, property="aspectSet")
@JsonSubTypes({
    @JsonSubTypes.Type(value=ArticleEntity.class, name="article"),
    @JsonSubTypes.Type(value=BlogEntity.class, name="blog")
}) 
public abstract class ContentEntityJacksonMixin {

}
