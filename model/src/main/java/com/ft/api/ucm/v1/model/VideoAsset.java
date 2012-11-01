package com.ft.api.ucm.v1.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class VideoAsset implements Asset {

	private String name;
	private VideoFields fields;
	private String uuid;

	public VideoAsset() {
	}

	public VideoAsset(VideoFields fields) {
		this.fields = fields;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public VideoFields getFields() {
		return fields;
	}

	public void setFields(VideoFields fields) {
		this.fields = fields;
	}

	public void setType(String type) {
	}

}
