package com.ft.unifiedContentModel.model;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@XmlTransient
@XmlSeeAlso({ArticleEntity.class})
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
		notNull(apiUrl);
		setId(id);
		setApiUrl(apiUrl);
	}
	
	@Override
	public void setAspectSet(String aspectSet) {
		this.aspectSet = aspectSet;
	}
	
	@XmlElement(name="aspectSet")
	public String getAspectSet() {
		return aspectSet;
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

	@XmlElement(name="location", namespace=XSDs.ASPECT_NAMESPACE)
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	@XmlElement(name="master", namespace=XSDs.ASPECT_NAMESPACE)
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}

	@XmlElement(name="packaging", namespace=XSDs.ASPECT_NAMESPACE)
	public Packaging getPackaging() {
		return packaging;
	}
	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	@XmlElement(name="body", namespace=XSDs.ASPECT_NAMESPACE)
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}

	@XmlElement(name="summary", namespace=XSDs.ASPECT_NAMESPACE)
	public Summary getSummary() {
		return summary;
	}
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	
	@XmlElement(name="metadata", namespace=XSDs.METADATA_NAMESPACE)
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	@Override
	@XmlElementWrapper(name="package", namespace=XSDs.CONTENTITEM_NAMESPACE)
	@XmlElement(name="packageItem", namespace=XSDs.CONTENTITEM_NAMESPACE)
	public List<ContentPackageEntry> getPackage() {
		return contentPackage;
	}
	public void setPackage(List<ContentPackageEntry> contentPackage) {
		this.contentPackage = contentPackage;
	}
	
	@Override
	@XmlElementWrapper(name="images", namespace=XSDs.CONTENTITEM_NAMESPACE)
	@XmlElement(name="image", namespace=XSDs.IMAGE_NAMESPACE)
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images){
		this.images = images;
	}
}
