package com.ft.unifiedContentModel.model;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title",
		"body", "lifecycle", "location", "summary", "packaging", "master", "editorial", "provenance", "metadata", 
		"images", "package"})
public class ArticleEntity extends ContentEntity implements Article {
	
	private Editorial editorial;
	private Provenance provenance;
	
	public ArticleEntity() {}
	
	public ArticleEntity(String id, String apiUrl){
		super(id, apiUrl);
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
					.add("summary", getSummary())
					.add("metadata", getMetadata())
					.add("contentPackage", getPackage())
					.add("images", getImages())
					.add("master", getMaster())
					.add("editorial", editorial)
					.add("provenance", provenance);
	}	
}
