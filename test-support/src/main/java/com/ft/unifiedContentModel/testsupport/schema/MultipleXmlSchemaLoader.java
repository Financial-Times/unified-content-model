package com.ft.unifiedContentModel.testsupport.schema;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

public class MultipleXmlSchemaLoader implements XmlSchemaLoader {

	
	private static final Log LOGGER = LogFactory.getLog(MultipleXmlSchemaLoader.class);
	
	private Schema schema; 
	private List<? extends Resource> resources;
	
	public MultipleXmlSchemaLoader(){}
	
	public MultipleXmlSchemaLoader(List<? extends Resource> resources){
		this.resources = resources;
	}
	
	@Override
	public Schema getSchema() {
		if(schema == null){
			try {
				schema = loadSchemas(resources);
			} catch (SAXException e) {
				LOGGER.error("Error loading schema",e);
			}
		}
		return schema;
	}
	
	private Schema loadSchemas(List<? extends Resource> schemaResources) throws SAXException {
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
		List<URL> schemaUrls = new ArrayList<URL>();
		for(Resource schemaResource: schemaResources){
			try {
				URL schemaUrl = schemaResource.getURL();
				schemaUrls.add(schemaUrl);
			} catch (IOException e) {
				throw new SAXException("Schema "+schemaResource+" does not exist", e);
			}
		}

		schema = schemaFactory.newSchema(urlArrayToSourceArray(schemaUrls.toArray(new URL[schemaUrls.size()])));
		LOGGER.debug("Schema : " + schema.toString());
		
		return schema;
	}
	
	private Source[] urlArrayToSourceArray(URL[] urls){
		Source[] sources = new Source[urls.length];
		for(int i = 0; i < urls.length; i++){
			sources[i] = new StreamSource(urls[i].toExternalForm());
		}
		return sources;
			
	}
	
	public void setResources(List<? extends Resource> resources){
		this.resources = resources;
	}
	

}
