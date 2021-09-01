package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ft.api.ucm.model.v1.aspect.AspectEnum;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

@JsonPropertyOrder({
  "aspectSet",
  "aspects",
  "modelVersion",
  "id",
  "apiUrl",
  "title",
  "body",
  "lifecycle",
  "nature",
  "location",
  "summary",
  "packaging",
  "master",
  "editorial",
  "textualBody",
  "usage",
  "metadata",
  "images",
  "package",
  "assets",
  "mediaAssets"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogPostEntity extends TextualEntity implements BlogPost, AssetAware {

  private List<MediaAsset> mediaAssets;
  private Map<String, MediaAsset> mediaAssetMap;
  private List<Asset> assets;
  private Map<String, Asset> assetMap;

  public BlogPostEntity() {}

  public BlogPostEntity(String id, String apiUrl) {
    super(id, apiUrl);
  }

  @Override
  public void suppressAspect(String aspect) {
    super.suppressAspect(aspect);
    AspectEnum aspectValue = AspectEnum.getByValue(aspect);
    switch (aspectValue) {
      case MEDIAASSETS:
        setMediaAssets(null);
        break;
      case ASSETS:
        setAssets(null);
        break;
      default:
        break;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BlogPostEntity) {
      BlogPostEntity a = (BlogPostEntity) o;
      return Objects.equal(this.getId(), a.getId());
    }
    return false;
  }

  @Override
  protected ToStringHelper toStringHelper() {
    ToStringHelper toStringHelper = super.toStringHelper();
    return toStringHelper
        .add("aspectSet", getAspectSet())
        .add("aspects", getAspects())
        .add("location", getLocation())
        .add("title", getTitle())
        .add("nature", getNature())
        .add("body", getBody())
        .add("lifecycle", getLifecycle())
        .add("packaging", getPackaging())
        .add("summary", getSummary())
        .add("metadata", getMetadata())
        .add("contentPackage", getPackage())
        .add("images", getImages())
        .add("master", getMaster())
        .add("editorial", getEditorial());
  }

  @Override
  @JsonIgnore
  public Map<String, Asset> getAssetMap() {
    return assetMap;
  }

  @Override
  @JsonIgnore
  public Map<String, MediaAsset> getMediaAssetMap() {
    return mediaAssetMap;
  }

  @JsonIgnore
  public void setAssetMap(Map<String, Asset> assetMap) {
    this.assetMap = assetMap;
  }

  @JsonIgnore
  public void setMediaAssetMap(Map<String, MediaAsset> mediaAssetMap) {
    this.mediaAssetMap = mediaAssetMap;
  }

  @Override
  public List<MediaAsset> getMediaAssets() {
    return mediaAssets;
  }

  @Override
  public void setMediaAssets(List<MediaAsset> mediaAssets) {
    this.mediaAssets = mediaAssets;
  }

  @Override
  public void add(MediaAsset asset) {
    if (mediaAssets == null) {
      mediaAssets = Lists.newArrayList();
    }
    mediaAssets.add(asset);
  }

  @Override
  public List<Asset> getAssets() {
    return assets;
  }

  @Override
  public void setAssets(List<Asset> assets) {
    this.assets = assets;
  }

  @Override
  public void add(Asset asset) {
    if (assets == null) {
      assets = Lists.newArrayList();
    }
    assets.add(asset);
  }
}
