package com.ft.unifiedContentModel.model;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title",
		"body", "lifecycle", "location", "summary", "packaging", "master", "metadata", 
		"images", "package"})
public class BlogEntity extends ContentEntity implements Blog{
	
	public BlogEntity() {}
	
	public BlogEntity(String id, String apiUrl){
		super(id, apiUrl);
	}

	@Override
	public boolean equals(Object o) {
		if(o == this){
			return true;
		}
		if(o instanceof BlogEntity) {
			BlogEntity a = (BlogEntity)o;
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
					.add("master", getMaster());
	}

}
