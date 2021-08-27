package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;

@JsonDeserialize(as = MetadataImpl.class)
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

  Set<Tag> getRegions();

  Set<Tag> getSections();

  Set<Tag> getSpecialReports();

  Set<Tag> getSubjects();

  Set<Tag> getTopics();

  Set<Tag> getAuthors();
}
