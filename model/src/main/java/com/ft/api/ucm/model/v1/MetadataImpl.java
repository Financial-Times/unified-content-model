package com.ft.api.ucm.model.v1;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ft.api.ucm.model.v1.metadata.Tag;
import com.google.common.base.Objects;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"primarySection", "primaryTheme", "tags", "brand", "genre", "icb", "iptc", 
	"mediaType", "organisations", "people", "regions", "sections", "specialReports", "subjects", "topics", "authors"})
public class MetadataImpl implements Metadata {
	
	private Tag primarySection;
	private Tag primaryTheme;
	private Set<Tag> tags;
	private Set<Tag> brand;
	private Set<Tag> genre;
	private Set<Tag> icb;
	private Set<Tag> iptc;
	private Set<Tag> mediaType;
	private Set<Tag> organisations;
	private Set<Tag> people;
	private Set<Tag> regions;
	private Set<Tag> sections;
	private Set<Tag> specialReports;
	private Set<Tag> subjects;
	private Set<Tag> topics;
    private Set<Tag> authors;
	
	public MetadataImpl() {
		// required for creating empty metadata so can return this if metadata aspect is requested
	}
	
	public MetadataImpl(Tag primarySection, Tag primaryTheme, Set<Tag> tags) {
		this.primarySection = primarySection;
		this.primaryTheme = primaryTheme;
		this.tags = tags;
	}
	
	public MetadataImpl(Tag primarySection, Tag primaryTheme, Set<Tag> tags,
			Set<Tag> brand, Set<Tag> genre, Set<Tag> icb, Set<Tag> iptc,
			Set<Tag> mediaType, Set<Tag> organisations, Set<Tag> people,
			Set<Tag> regions, Set<Tag> sections, Set<Tag> specialReports,
			Set<Tag> subjects, Set<Tag> topics, Set<Tag> authors) {
		this.primarySection = primarySection;
		this.primaryTheme = primaryTheme;
		this.tags = tags;
		this.brand = brand;
		this.genre = genre;
		this.icb = icb;
		this.iptc = iptc;
		this.mediaType = mediaType;
		this.organisations = organisations;
		this.people = people;
		this.regions = regions;
		this.sections = sections;
		this.specialReports = specialReports;
		this.subjects = subjects;
		this.topics = topics;
        this.authors = authors;
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
	
	public Set<Tag> getBrand() {
		return brand;
	}

	public void setBrand(Set<Tag> brand) {
		this.brand = brand;
	}

	public Set<Tag> getGenre() {
		return genre;
	}

	public void setGenre(Set<Tag> genre) {
		this.genre = genre;
	}

	public Set<Tag> getIcb() {
		return icb;
	}

	public void setIcb(Set<Tag> icb) {
		this.icb = icb;
	}

	public Set<Tag> getIptc() {
		return iptc;
	}

	public void setIptc(Set<Tag> iptc) {
		this.iptc = iptc;
	}

	public Set<Tag> getMediaType() {
		return mediaType;
	}

	public void setMediaType(Set<Tag> mediaType) {
		this.mediaType = mediaType;
	}

	public Set<Tag> getOrganisations() {
		return organisations;
	}

	public void setOrganisations(Set<Tag> organisations) {
		this.organisations = organisations;
	}

	public Set<Tag> getPeople() {
		return people;
	}

	public void setPeople(Set<Tag> people) {
		this.people = people;
	}

	public Set<Tag> getRegions() {
		return regions;
	}

	public void setRegions(Set<Tag> regions) {
		this.regions = regions;
	}

	public Set<Tag> getSections() {
		return sections;
	}

	public void setSections(Set<Tag> sections) {
		this.sections = sections;
	}

	public Set<Tag> getSpecialReports() {
		return specialReports;
	}

	public void setSpecialReports(Set<Tag> specialReports) {
		this.specialReports = specialReports;
	}

	public Set<Tag> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Tag> subjects) {
		this.subjects = subjects;
	}

	public Set<Tag> getTopics() {
		return topics;
	}

	public void setTopics(Set<Tag> topics) {
		this.topics = topics;
	}

    @Override
    public Set<Tag> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Tag> authors) {
        this.authors = authors;
    }

    @Override
	public String toString() {
		return Objects.toStringHelper(this)
						.add("primarySection", primarySection)
						.add("primaryTheme", primaryTheme)
						.add("tags", tags)
						.add("brand", brand)
						.add("genre", genre)
						.add("icb", icb)
						.add("iptc", iptc)
						.add("mediaType", mediaType)
						.add("organisations", organisations)
						.add("people", people)
						.add("regions", regions)
						.add("sections", sections)
						.add("specialReports", specialReports)
						.add("subjects", subjects)
						.add("topics", topics)
                        .add("authors", authors)
						.toString();
	}
	
	
}
