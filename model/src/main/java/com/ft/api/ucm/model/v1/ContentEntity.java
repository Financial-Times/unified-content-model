package com.ft.api.ucm.model.v1;


import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ft.api.ucm.model.v1.aspect.AspectEnum;
import com.google.common.base.Objects;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public abstract class ContentEntity extends SimpleEntity implements Package, Images, AspectSetAware {
	
	private Editorial editorial;
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
	private Provenance provenance;
    private Usage usage;
	
	public ContentEntity(){
		// required for JAXB
	}
	
	public ContentEntity(String id, String apiUrl){
		notNull(id,"Entity id cannot be null");
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
	
	public void suppressAspect(String aspect) {
		AspectEnum aspectValue = AspectEnum.getByValue(aspect); 
		notNull(aspectValue, "aspect " + aspect + " is not a valid AspectEnum value");
		switch (aspectValue) {
			case TITLE: setTitle(null); break;
			case LIFECYCLE: setLifecycle(null); break;
			case NATURE: setNature(null); break;
			case MASTER: setMaster(null); break;
			case PACKAGING: setPackaging(null); break;
			case PACKAGE: setPackage(null); break;
			case BODY: setBody(null); break;
			case SUMMARY: setSummary(null); break;
			case LOCATION: setLocation(null); break;
			case METADATA: setMetadata(null); break;
			case IMAGES: setImages(null); break;
			case EDITORIAL :setEditorial(null); break;
			case PROVENANCE :setProvenance(null); break;
            case USAGE: setUsage(null); break;
			default: break;
		}
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
	
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Editorial getEditorial() {
		return editorial;
	}
	
	public void setProvenance(Provenance provenance) {
	    this.provenance = provenance;
	}
	
	public Provenance getProvenance(){
	    return provenance;
	}

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
	
	
}
