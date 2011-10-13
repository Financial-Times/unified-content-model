package com.ft.unifiedContentModel.testsupport.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.ft.unifiedContentModel.testsupport.schema.MultipleXmlSchemaLoader;
import com.ft.unifiedContentModel.testsupport.schema.SingleXmlSchemaLoader;

public class XmlResponseValidatorTest {
	
	@Test
	public void singleSchemaPassesFromStream() throws IOException {
		XmlResponseValidator validator =  new XmlResponseValidator(new SingleXmlSchemaLoader(new ClassPathResource("/validation/test_schema.xsd")));
		InputStream dummyExampleInputStream = getClass().getResourceAsStream("/validation/test_sample.xml");
		assertTrue(validator.isValid(dummyExampleInputStream));
	}
	
	@Test
	public void invalidSingleSchemaFailsFromStream() throws IOException {
		XmlResponseValidator validator =  new XmlResponseValidator(new SingleXmlSchemaLoader(new ClassPathResource("/validation/test_schema.xsd")));
		InputStream dummyExampleInputStream = getClass().getResourceAsStream("/validation/test_sample_invalid.xml");
		assertFalse(validator.isValid(dummyExampleInputStream));
	}
	
	@Test
	@Ignore
	public void multipleSchemaPassesFromStream() throws IOException {
		XmlResponseValidator validator = new XmlResponseValidator(
				new MultipleXmlSchemaLoader(
						Arrays.asList(
								new ClassPathResource("/validation/test_schema_multiple_1.xsd"),
								new ClassPathResource("/validation/test_schema_multiple_2.xsd")
								)
						)
				);
						
		InputStream dummyExampleInputStream = getClass().getResourceAsStream("/validation/test_sample_multiple.xml");
		assertTrue(validator.isValid(dummyExampleInputStream));
	}

}
