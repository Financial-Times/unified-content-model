package com.ft.unifiedContentModel.testsupport.schema;

import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

public class SingleXmlSchemaLoader implements XmlSchemaLoader {

	
	private static final Log LOGGER = LogFactory.getLog(SingleXmlSchemaLoader.class);
	
	private Schema schema; 
	private Resource resource;
	
	public SingleXmlSchemaLoader(){
		
	}
	
	public SingleXmlSchemaLoader(Resource resource){
		this.resource = resource;
	}
	
	
	@Override
	public Schema getSchema() {
		if(schema == null){
			try {
				schema = loadSchema(resource);
			} catch (SAXException e) {
				LOGGER.error("Error loading schema",e);
			}
		}
		return schema;
	}
	
	private Schema loadSchema(Resource schemaResource) throws SAXException {
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
		URL schemaUrl = null;
		try {
			schemaUrl = schemaResource.getURL();
		} catch (IOException e) {
			throw new SAXException("Schema "+schemaResource+" does not exist", e);
		}

		schema = schemaFactory.newSchema(schemaUrl);
		LOGGER.debug("Schema : " + schema.toString());
		
		return schema;
	}
	
	public void setResource(Resource resource){
		this.resource = resource;
	}
	

}
