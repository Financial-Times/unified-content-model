package com.ft.unifiedContentModel.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ft.unifiedContentModel.model.metadata.Tag;
import com.ft.unifiedContentModel.model.metadata.TagImpl;
import com.google.common.base.Objects;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name="metadata", namespace=XSDs.METADATA_NAMESPACE, propOrder = { "primarySection", "primaryTheme", "tags" })
public class MetadataImpl implements Metadata {

	private Tag primarySection;
	private Tag primaryTheme;
	private Set<Tag> tags;
	
	public MetadataImpl() {
		// required for JAXB
	}
	
	public MetadataImpl(Tag primarySection, Tag primaryTheme, Set<Tag> tags) {
		this.primarySection = primarySection;
		this.primaryTheme = primaryTheme;
		this.tags = tags;
	}

	@Override
	@XmlElement(name="primarySection", namespace=XSDs.METADATA_NAMESPACE)
	public Tag getPrimarySection() {
		return primarySection;
	}

	public void setPrimarySection(Tag primarySection) {
		this.primarySection = primarySection;
	}

	@Override
	@XmlElement(name="primaryTheme", namespace=XSDs.METADATA_NAMESPACE)
	public Tag getPrimaryTheme() {
		return primaryTheme;
	}

	public void setPrimaryTheme(Tag primaryTheme) {
		this.primaryTheme = primaryTheme;
	}

	@Override
	@XmlElementWrapper(name="tags", namespace=XSDs.METADATA_NAMESPACE)
	@XmlElement(name="tag", type=TagImpl.class)
	public Set<Tag> getTags() {
		return tags;
	}
	
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
						.add("primarySection", primarySection)
						.add("primaryTheme", primaryTheme)
						.add("tags", tags)
						.toString();
	}
	
	
}
