package com.ft.unifiedContentModel.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title",
	"body", "lifecycle", "location", "packaging", "master", "editorial", "provenance", "metadata", 
	"images", "package", "mediaAssets"})
public class SlideshowArticleEntity extends ContentEntity implements SlideshowArticle, MediaAssetAware {

	private Editorial editorial;
	private Provenance provenance;
	private List<MediaAsset> mediaAssets;

	public SlideshowArticleEntity() {
	}
	
	public SlideshowArticleEntity(String id, String apiUrl){
		super(id, apiUrl);
	}
	
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	@Override
	public Editorial getEditorial() {
		return editorial;
	}

	public void setProvenance(Provenance provenance) {
		this.provenance = provenance;
	}
	
	@Override
	public Provenance getProvenance() {
		return provenance;
	}

    @Override
    public List<MediaAsset> getMediaAssets() {
        return mediaAssets;
    }

    public void setMediaAssets(List<MediaAsset> mediaAssets) {
        this.mediaAssets = mediaAssets;
    }

    @Override
	public boolean equals(Object o) {
		if(o == this){
			return true;
		}
		if(o instanceof ContentEntity) {
			ContentEntity a = (ContentEntity)o;
			return Objects.equal(this.getId(), a.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
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
					.add("editorial", editorial)
					.add("provenance", provenance)
					.add("mediaAssets", mediaAssets);
	}	
	
}