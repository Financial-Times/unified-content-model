package com.ft.unifiedContentModel.model;

import com.google.common.base.Objects;
import java.util.List;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonTypeName(value="storyPackageItem")
@JsonPropertyOrder({"aspectSet", "aspects", "id", "apiUrl", "packaging", "provenance"})
public class ContentPackageEntry implements Identifiable, AspectSetAware {
	
	private String id;
	private String apiUrl;
	private Packaging packaging;
	private Provenance provenance;
	private String aspectSet;
	private List<String> aspects;
	
	public ContentPackageEntry(String apiUrl,String headline, String kicker, String source, String guid) {
		this.apiUrl = apiUrl;
		this.id = guid;
		this.packaging = new PackagingImpl(kicker, headline);
		this.provenance = new ProvenanceImpl(source);
	}


	@SuppressWarnings("unused")
	private ContentPackageEntry(){
		// required for JAXB
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
	
	public String getAspectSet() {
		return aspectSet;
	}

	@Override
	public void setAspectSet(String aspectSet) {
		this.aspectSet = aspectSet;
	}
	

	public List<String> getAspects() {
		return aspects;
	}
	@Override
	public void setAspects(List<String> aspects) {
		this.aspects = aspects;
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
