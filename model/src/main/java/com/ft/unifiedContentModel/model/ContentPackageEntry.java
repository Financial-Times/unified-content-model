package com.ft.unifiedContentModel.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.common.base.Objects;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonTypeName(value="storyPackageItem")
@XmlType(namespace=XSDs.CONTENTITEM_NAMESPACE, propOrder = {"aspectSet", "aspects", "id", "apiUrl", "packaging", "provenance"})
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
	@XmlElement(name="id")
	public String getId() {
		return id;
	}
	@Override
	public void setId(String guid) {
		this.id = guid;
	}
	
	@XmlElement(name="apiUrl")
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	@XmlElement(name="packaging", namespace=XSDs.ASPECT_NAMESPACE)
	public Packaging getPackaging() {
		return packaging;
	}
	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}
	
	@XmlElement(name="provenance", namespace=XSDs.ASPECT_NAMESPACE)
	public Provenance getProvenance() {
		return provenance;
	}
	public void setProvenance(Provenance provenance) {
		this.provenance = provenance;
	}
	
	@XmlElement(name="aspectSet")
	public String getAspectSet() {
		return aspectSet;
	}
	@Override
	public void setAspectSet(String aspectSet) {
		this.aspectSet = aspectSet;
	}
	
	@XmlElementWrapper(name="aspects")
	@XmlElement(name="aspect")
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
