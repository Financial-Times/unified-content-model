package com.ft.unifiedContentModel.marshalling.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;

import com.ft.unifiedContentModel.marshalling.view.SimpleJacksonJsonView;

/**
 * Test methods copied from MappingJacksonJsonViewTest in spring framework
 * and updated to take account of the changes made in SimpleJacksonJsonView.
 */
public class SimpleJacksonJsonViewTest {

	private SimpleJacksonJsonView view;

	private MockHttpServletRequest request;

	private MockHttpServletResponse response;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();

		view = new SimpleJacksonJsonView();
	}

	@Test
	public void renderSimpleMap() throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.getObjectName()).thenReturn("binding_result");
		model.put("bindingResult", bindingResult);
		model.put("foo", "bar");

		view.render(model, request, response);
		
		assertEquals("no-cache", response.getHeader("Pragma"));
		assertEquals("no-cache, no-store, max-age=0", response.getHeader("Cache-Control"));
		assertNotNull(response.getHeader("Expires"));
		assertTrue(response.getContentLength()>0);
		assertEquals(SimpleJacksonJsonView.DEFAULT_CONTENT_TYPE, response.getContentType());

		String jsonResult = response.getContentAsString();
		assertTrue(jsonResult.length() > 0);
	}

	@Test
	public void renderCaching() throws Exception {
		view.setDisableCaching(false);

		Map<String, Object> model = new HashMap<String, Object>();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.getObjectName()).thenReturn("binding_result");
		model.put("bindingResult", bindingResult);
		model.put("foo", "bar");

		view.render(model, request, response);

		assertNull(response.getHeader("Pragma"));
		assertNull(response.getHeader("Cache-Control"));
		assertNull(response.getHeader("Expires"));
	}

	@Test
	public void renderSimpleMapPrefixed() throws Exception {
		view.setPrefixJson(true);
		renderSimpleMap();
	}

	@Test
	public void renderSimpleBean() throws Exception {

		Object bean = new TestBeanSimple();
		Map<String, Object> model = new HashMap<String, Object>();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.getObjectName()).thenReturn("binding_result");
		model.put("bindingResult", bindingResult);
		model.put("foo", bean);

		view.render(model, request, response);

		assertTrue(response.getContentAsString().length() > 0);
	}

	@Test
	public void renderSimpleBeanPrefixed() throws Exception {

		view.setPrefixJson(true);
		renderSimpleBean();
	}

	@Test
	public void renderWithCustomSerializerLocatedByAnnotation() throws Exception {

		Object bean = new TestBeanSimpleAnnotated();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("model", bean);

		view.render(model, request, response);

		assertTrue(response.getContentAsString().length() > 0);
		assertEquals("{\"testBeanSimple\":\"custom\"}", response.getContentAsString());
	}

	@Test
	public void renderOnlyModelAttributeValue() throws Exception {

		Set<String> attrs = new HashSet<String>();
		attrs.add("foo");
		attrs.add("baz");
		attrs.add(ModelAndViewNames.MODEL_NAME);

		view.setRenderedAttributes(attrs);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("foo", "fooValue");
		model.put("bar", "barValue");
		model.put(ModelAndViewNames.MODEL_NAME, "modelValue");

		view.render(model, request, response);

		String result = response.getContentAsString();
		assertTrue(result.length() > 0);
		assertTrue(!result.contains("\"fooValue\""));
		assertTrue(!result.contains("\"barValue\""));
		assertTrue(result.contains("\"modelValue\""));
	}


	public static class TestBeanSimple {

		private String value = "foo";

		private boolean test = false;

		private long number = 42;

		private TestChildBean child = new TestChildBean();

		public String getValue() {
			return value;
		}

		public boolean getTest() {
			return test;
		}

		public long getNumber() {
			return number;
		}

		public Date getNow() {
			return new Date();
		}

		public TestChildBean getChild() {
			return child;
		}
	}

	@JsonSerialize(using=TestBeanSimpleSerializer.class)
	public static class TestBeanSimpleAnnotated extends TestBeanSimple {

	}

	public static class TestChildBean {

		private String value = "bar";

		private String baz = null;

		private TestBeanSimple parent = null;

		public String getValue() {
			return value;
		}

		public String getBaz() {
			return baz;
		}

		public TestBeanSimple getParent() {
			return parent;
		}

		public void setParent(TestBeanSimple parent) {
			this.parent = parent;
		}
	}

	public static class TestBeanSimpleSerializer extends JsonSerializer<TestBeanSimple> {

		@Override
		public void serialize(TestBeanSimple value, JsonGenerator jgen, SerializerProvider provider)
				throws IOException {

			jgen.writeStartObject();
			jgen.writeFieldName("testBeanSimple");
			jgen.writeString("custom");
			jgen.writeEndObject();

		}
	}
}