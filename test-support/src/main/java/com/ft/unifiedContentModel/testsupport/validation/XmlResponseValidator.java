package com.ft.unifiedContentModel.testsupport.validation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.ft.unifiedContentModel.testsupport.schema.XmlSchemaLoader;

public class XmlResponseValidator implements ResponseValidator {
	
	private static Log logger = LogFactory.getLog(XmlResponseValidator.class);
		
	private Schema schema;
	private XmlSchemaLoader xmlSchemaLoader;
	
	public XmlResponseValidator () {
	}
	
	public XmlResponseValidator(XmlSchemaLoader xmlSchemaLoader) {
		this.xmlSchemaLoader = xmlSchemaLoader;
	}
	
	@Override
	public boolean isValid(InputStream source) {
		return validateSchemaComplianceFromInputStream(source);
	}
	
	private boolean validateSchemaComplianceFromInputStream(InputStream xml) {
		try{
			if(schema == null){
				logger.info("Loading schema");
				schema = xmlSchemaLoader.getSchema();
				if(schema == null){
					logger.info("Error loading schema. All validations will be false");
					return false;
				}
			}
			return validateXml(xml);
		} catch (SAXException e) {
			logger.debug(e.getMessage(), e);
			return false;
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
			return false;
		}
	}
	
	private boolean validateXml(InputStream inputStream) throws SAXException, IOException {
		boolean valid = false;
		Validator validator = schema.newValidator();
		
		TestErrorHandler errorHandler = new TestErrorHandler();
		validator.setErrorHandler(errorHandler);

		SAXSource source = new SAXSource(new InputSource(inputStream));
		validator.validate(source);
		
		if(errorHandler.getErrors().isEmpty() && errorHandler.getWarnings().isEmpty()){
			valid = true;
		}
		return valid;
	}
	
	private class TestErrorHandler implements ErrorHandler {
		
		private List<SAXParseException> errors = new ArrayList<SAXParseException>();
		private List<SAXParseException> warnings = new ArrayList<SAXParseException>();

		@Override
		public void warning(SAXParseException exception) throws SAXException {
			logger.warn(exception.getMessage());
			warnings.add(exception);
		}

		@Override
		public void error(SAXParseException exception) throws SAXException {
			logger.error(exception.getMessage());
			errors.add(exception);
		}

		@Override
		public void fatalError(SAXParseException exception) throws SAXException {
			logger.error(exception.getMessage());
			errors.add(exception);			
		}

		public List<SAXParseException> getErrors() {
			return errors;
		}

		public List<SAXParseException> getWarnings() {
			return warnings;
		}
		
	}
	
	public XmlSchemaLoader getXmlSchemaLoader() {
		return xmlSchemaLoader;
	}

	public void setXmlSchemaLoader(XmlSchemaLoader schemaLoader) {
		this.xmlSchemaLoader = schemaLoader;
	}

	
}
