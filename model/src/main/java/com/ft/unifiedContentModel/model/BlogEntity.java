package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonTypeName;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

@XmlType(namespace=XSDs.CONTENTITEM_NAMESPACE, propOrder = {"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title", 
		"body", "lifecycle", "location", "summary", "packaging", "master", "metadata", 
		"images", "package"})
@XmlSeeAlso({ContentEntity.class, SimpleEntity.class, IdentifiableEntity.class})
@JsonTypeName(value="blog")
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
		return super.toStringHelper()
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
