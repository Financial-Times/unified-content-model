package com.ft.unifiedContentModel.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class Video implements Asset {

	private String name;
	private VideoFields fields;
	private String uuid;

	public Video() {
	}

	public Video(String name, VideoFields fields) {
		this.name = name;
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
