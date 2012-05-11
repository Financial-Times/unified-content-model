package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title",
	"body", "lifecycle", "location", "packaging", "master", "editorial", "provenance", "metadata", 
	"images", "package", "slideshow"})
public class SlideshowArticleEntity extends ContentEntity implements SlideshowArticle {

	private Editorial editorial;
	private Provenance provenance;
	private Slideshow slideshow;
	
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
	public Slideshow getSlideshow() {
		return slideshow;
	}

	public void setSlideshow(Slideshow slideshow) {
		this.slideshow = slideshow;
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
					.add("contentPackage", getPackage())
					.add("images", getImages())
					.add("master", getMaster())
					.add("editorial", editorial)
					.add("provenance", provenance)
					.add("slideshow", slideshow);
	}	
	
}
