package com.ft.unifiedContentModel.model;


import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"name", "type", "fields"})
public class DataTable implements Asset {

	private String name;
	private DataTableFields fields;

	public DataTable() {
	}

	public DataTable(String name, DataTableFields fields) {
		this.name = name;
		this.fields = fields;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DataTableFields getFields() {
		return fields;
	}

	public void setFields(DataTableFields fields) {
		this.fields = fields;
	}
}
