package com.ft.unifiedContentModel.testsupport.client.bind;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import com.ft.unifiedContentModel.mixin.ArticleEntityJacksonMixin;
import com.ft.unifiedContentModel.mixin.BlogEntityJacksonMixin;
import com.ft.unifiedContentModel.mixin.ContentEntityJacksonMixin;
import com.ft.unifiedContentModel.model.ArticleEntity;
import com.ft.unifiedContentModel.model.BlogEntity;
import com.ft.unifiedContentModel.model.ContentEntity;

/**
 * This class extends the ObjectMapper class of the Jackson framework to 
 * read in JAXB annotations
 * 
 * Note:Due to the nature of the ObjectMapper class
 * these customisations could not be done through the Spring Framework configuration
 * (or at least not easily)
 *
 */
public class JAXBObjectMapper extends ObjectMapper {

	public JAXBObjectMapper() {
		AnnotationIntrospector primary = new JaxbAnnotationIntrospector();
		AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
	    AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary, secondary);
	    setSerializationConfig(getSerializationConfig().withAnnotationIntrospector(pair));
		
		getDeserializationConfig().addMixInAnnotations(ArticleEntity.class, ArticleEntityJacksonMixin.class);
		getDeserializationConfig().addMixInAnnotations(BlogEntity.class, BlogEntityJacksonMixin.class);
		getDeserializationConfig().addMixInAnnotations(ContentEntity.class, ContentEntityJacksonMixin.class);
    }
}
