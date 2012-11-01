package com.ft.api.ucm.v1.model.mixin;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import com.ft.api.ucm.v1.model.ArticleEntity;
import com.ft.api.ucm.v1.model.BlogEntity;
import com.ft.api.ucm.v1.model.PodcastEntity;
import com.ft.api.ucm.v1.model.SlideshowArticleEntity;
import com.ft.api.ucm.v1.model.VideoEntity;


@JsonTypeInfo(use=Id.NAME, include=As.PROPERTY, property="aspectSet")
@JsonSubTypes({
    @JsonSubTypes.Type(value=ArticleEntity.class, name="article"),
    @JsonSubTypes.Type(value=SlideshowArticleEntity.class, name="slideshow"),
    @JsonSubTypes.Type(value=BlogEntity.class, name="blog"),
    @JsonSubTypes.Type(value=VideoEntity.class, name="video"),
    @JsonSubTypes.Type(value=PodcastEntity.class, name="podcast")
}) 
public abstract class ContentEntityJacksonMixin {

}
