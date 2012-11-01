package com.ft.api.ucm.model.v1;


import static org.springframework.util.Assert.notNull;

import java.util.List;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.google.common.base.Objects;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public abstract class ContentEntity extends SimpleEntity implements Package, Images, AspectSetAware {
	
	private Location location;
	private Master master;
	private Packaging packaging;
	private Body body;
	private Summary summary;
	private Metadata metadata;
	private List<ContentPackageEntry> contentPackage;
	private List<Image> images;
	private String aspectSet;
	private List<String> aspects;
	
	public ContentEntity(){
		// required for JAXB
	}
	
	public ContentEntity(String id, String apiUrl){
		notNull(id);
		setId(id);
		setApiUrl(apiUrl);
	}
	
	@Override
	public void setAspectSet(String aspectSet) {
		this.aspectSet = aspectSet;
	}
	
	public String getAspectSet() {
		return aspectSet;
	}
	
	public List<String> getAspects() {
		return aspects;
	}
	
	@Override
	public void setAspects(List<String> aspects) {
		this.aspects = aspects;
	}

	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}

	public Packaging getPackaging() {
		return packaging;
	}
	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}

	public Summary getSummary() {
		return summary;
	}
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	@Override
	public List<ContentPackageEntry> getPackage() {
		return contentPackage;
	}
	public void setPackage(List<ContentPackageEntry> contentPackage) {
		this.contentPackage = contentPackage;
	}
	
	@Override
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images){
		this.images = images;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
	
	
}
