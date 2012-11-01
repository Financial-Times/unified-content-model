package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonPropertyOrder;


import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;


@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id", "apiUrl", "title", "lifecycle", "location", "master"})
public class VideoEntity extends ContentEntity implements Video {
	
	public VideoEntity() {}
	
	public VideoEntity(String id, String apiUrl){
		super(id, apiUrl);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this){
			return true;
		}
		if(o instanceof VideoEntity) {
			VideoEntity a = (VideoEntity)o;
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
					.add("master", getMaster());
	}


}
