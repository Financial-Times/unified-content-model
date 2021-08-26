package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Slideshow.class, name = "slideshow"),
  @JsonSubTypes.Type(value = VideoAsset.class, name = "video"),
  @JsonSubTypes.Type(value = TweetAsset.class, name = "tweet"),
  @JsonSubTypes.Type(value = PullQuote.class, name = "pullQuote"),
  @JsonSubTypes.Type(value = InteractiveGraphic.class, name = "interactiveGraphic"),
  @JsonSubTypes.Type(value = BackgroundNews.class, name = "backgroundNews"),
  @JsonSubTypes.Type(value = DataTable.class, name = "dataTable"),
  @JsonSubTypes.Type(value = PromoBox.class, name = "promoBox"),
  @JsonSubTypes.Type(value = NumbersComponent.class, name = "promoteNumber")
})
public interface Asset {
  String getName();

  void setName(String name);
}
