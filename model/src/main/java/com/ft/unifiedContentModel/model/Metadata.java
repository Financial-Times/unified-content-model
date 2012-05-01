package com.ft.unifiedContentModel.model;

import com.ft.unifiedContentModel.model.metadata.Tag;
import java.util.Set;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize(as=MetadataImpl.class)
public interface Metadata {

	Tag getPrimarySection();
	Tag getPrimaryTheme();
	Set<Tag> getTags();

}
