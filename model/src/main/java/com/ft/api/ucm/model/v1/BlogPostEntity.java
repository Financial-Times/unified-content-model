package com.ft.api.ucm.model.v1;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title",
		"body", "lifecycle", "nature","location", "summary", "packaging", "master", "editorial","metadata", 
		"images", "package"})
public class BlogPostEntity extends ContentEntity implements BlogPost{
	
	public BlogPostEntity() {}
	
	public BlogPostEntity(String id, String apiUrl){
		super(id, apiUrl);
	}

	@Override
	public boolean equals(Object o) {
		if(o == this){
			return true;
		}
		if(o instanceof BlogPostEntity) {
			BlogPostEntity a = (BlogPostEntity)o;
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
					.add("editorial",getEditorial());
	}

}
