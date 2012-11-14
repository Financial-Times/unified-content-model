package com.ft.api.ucm.model.v1;

import static org.springframework.util.Assert.notNull;

import com.ft.api.ucm.model.v1.aspect.AspectEnum;
import com.google.common.collect.Lists;
import java.util.List;

import java.util.Map;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title",
		"body", "lifecycle", "location", "summary", "packaging", "master", "editorial", "provenance", "metadata", 
		"images", "package", "assets", "mediaAssets"})
public class ArticleEntity extends ContentEntity implements Article, AssetAware {
	
	private Editorial editorial;
	private Provenance provenance;
	private List<MediaAsset> mediaAssets;
	private Map<String, MediaAsset> mediaAssetMap;
	private List<Asset> assets;
	private Map<String, Asset> assetMap;

	public ArticleEntity() {}
	
	public ArticleEntity(String id, String apiUrl){
		super(id, apiUrl);
		notNull(apiUrl);
	}
	
	@Override
	public void suppressAspect(String aspect) {
		super.suppressAspect(aspect);
		AspectEnum aspectValue = AspectEnum.getByValue(aspect); 
		switch (aspectValue) {
			case PROVENANCE: setProvenance(null); break;
			case EDITORIAL: setEditorial(null); break;
			case MEDIAASSETS: setMediaAssets(null); break;
			case ASSETS: setAssets(null); break;
		}
	}
	
	@Override
	public Editorial getEditorial() {
		return editorial;
	}
	
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public Provenance getProvenance() {
		return provenance;
	}

	public void setProvenance(Provenance provenance) {
		this.provenance = provenance;
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
		if(mediaAssets != null && mediaAssets.size() == 0){
			return null;
		}
		return mediaAssets;
	}

	@Override
	public void setMediaAssets(List<MediaAsset> mediaAssets) {
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
		if(assets != null && assets.size() == 0){
			return null;
		}
		return assets;
	}

	@Override
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
		if(o instanceof ArticleEntity) {
			ArticleEntity a = (ArticleEntity)o;
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
					.add("summary", getSummary())
					.add("metadata", getMetadata())
					.add("contentPackage", getPackage())
					.add("images", getImages())
					.add("master", getMaster())
					.add("editorial", editorial)
					.add("provenance", provenance)
					.add("mediaAssets", mediaAssets);
	}

}
