package com.ft.unifiedContentModel.model;

import com.ft.unifiedContentModel.model.metadata.Tag;
import com.google.common.base.Objects;
import java.util.Set;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"primarySection", "primaryTheme", "tags"})
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
	public Tag getPrimarySection() {
		return primarySection;
	}

	public void setPrimarySection(Tag primarySection) {
		this.primarySection = primarySection;
	}

	@Override
	public Tag getPrimaryTheme() {
		return primaryTheme;
	}

	public void setPrimaryTheme(Tag primaryTheme) {
		this.primaryTheme = primaryTheme;
	}

	@Override
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
