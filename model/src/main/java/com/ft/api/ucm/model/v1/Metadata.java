package com.ft.api.ucm.model.v1;

import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.ft.api.ucm.model.v1.metadata.Tag;

@JsonDeserialize(as=MetadataImpl.class)
public interface Metadata {

	Tag getPrimarySection();
	Tag getPrimaryTheme();
	Set<Tag> getTags();
	Set<Tag> getBrand();
	Set<Tag> getGenre();
	Set<Tag> getIcb();
	Set<Tag> getIptc();
	Set<Tag> getMediaType();
	Set<Tag> getOrganisations();
	Set<Tag> getPeople();
	Set<Tag> getRegions() ;
	Set<Tag> getSections();
	Set<Tag> getSpecialReports();
	Set<Tag> getSubjects();
	Set<Tag> getTopics();

}
