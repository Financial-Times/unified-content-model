package com.ft.api.ucm.model.v1;

import static org.springframework.util.Assert.notNull;

import com.ft.api.ucm.model.v1.aspect.AspectEnum;
import com.google.common.collect.Lists;
import java.util.List;

import java.util.Map;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title",
	"body", "lifecycle", "nature","location", "packaging", "master", "editorial", "provenance", "metadata", 
	"images", "package", "assets", "mediaAssets"})
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class SlideshowArticleEntity extends ContentEntity implements SlideshowArticle, AssetAware {

	private List<MediaAsset> mediaAssets;
	private List<Asset> assets;
	private Map<String, Asset> assetMap;
	private Map<String, MediaAsset> mediaAssetMap;

	public SlideshowArticleEntity() {
	}
	
	public SlideshowArticleEntity(String id, String apiUrl){
		super(id, apiUrl);
		notNull(apiUrl);
	}
	
	@Override
	public void suppressAspect(String aspect) {
		super.suppressAspect(aspect);
		AspectEnum aspectValue = AspectEnum.getByValue(aspect); 
		switch (aspectValue) {
			case PROVENANCE: setProvenance(null); break;
			case MEDIAASSETS: setMediaAssets(null); break;
			case ASSETS: setAssets(null); break;
			default: break;
		}
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
    public void
	setMediaAssets(List<MediaAsset> mediaAssets) {
        this.mediaAssets = mediaAssets;
    }

	@Override
	public void add(MediaAsset asset) {
		if(mediaAssets == null){
			mediaAssets = Lists.newArrayList();
		}
		mediaAssets.add(asset);
	}

	@Override
	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	@Override
	public void add(Asset asset) {
		if(assets == null){
			assets = Lists.newArrayList();
		}
		assets.add(asset);
	}

	@Override
	public boolean equals(Object o) {
		if(o == this){
			return true;
		}
		if(o instanceof SlideshowArticleEntity) {
			SlideshowArticleEntity a = (SlideshowArticleEntity)o;
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
					.add("body", getBody())
					.add("packaging", getPackaging())
					.add("metadata", getMetadata())
					.add("images", getImages())
					.add("master", getMaster())
					.add("editorial", getEditorial())
					.add("provenance", getProvenance())
					.add("mediaAssets", mediaAssets)
					.add("assets", assets);
	}
	
}
