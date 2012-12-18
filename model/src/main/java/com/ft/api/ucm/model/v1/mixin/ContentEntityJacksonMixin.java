package com.ft.api.ucm.model.v1.mixin;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import com.ft.api.ucm.model.v1.ArticleEntity;
import com.ft.api.ucm.model.v1.BlogEntity;
import com.ft.api.ucm.model.v1.PodcastEntity;
import com.ft.api.ucm.model.v1.SlideshowArticleEntity;
import com.ft.api.ucm.model.v1.VideoEntity;


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