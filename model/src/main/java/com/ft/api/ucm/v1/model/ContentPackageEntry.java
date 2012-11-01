package com.ft.api.ucm.v1.model;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonTypeName(value="storyPackageItem")
@JsonPropertyOrder({"id", "apiUrl", "packaging", "provenance"})
public class ContentPackageEntry implements Identifiable {
	
	private String id;
	private String apiUrl;
	private Packaging packaging;
	private Provenance provenance;
	
	public ContentPackageEntry(String apiUrl,String headline, String kicker, String source, String guid) {
		this.apiUrl = apiUrl;
		this.id = guid;
		this.packaging = new PackagingImpl(kicker, headline);
		this.provenance = new ProvenanceImpl(source);
	}


	@SuppressWarnings("unused")
	private ContentPackageEntry(){
		// required for Jackson
	}

	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String guid) {
		this.id = guid;
	}
	
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	public Packaging getPackaging() {
		return packaging;

	}
	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}
	
	public Provenance getProvenance() {
		return provenance;
	}
	public void setProvenance(Provenance provenance) {
		this.provenance = provenance;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null){
			return false;
		}
		if(o instanceof ContentPackageEntry) {
			ContentPackageEntry a = (ContentPackageEntry)o;
			return Objects.equal(this.id, a.id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}
}
