package com.ft.api.ucm.model.v1.items.urls;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ContentItemsUrlTemplateTest {

	private static final String BASE_API_URL = "http://api.ft.com";
	
	private ContentItemsUrlTemplate template;
	
	@Before
	public void setup() {
		template = new ContentItemsUrlTemplate(BASE_API_URL);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void failsWithNullBaseApiUrl() {
		new ContentItemUrlTemplate(null);
	}
	
	@Test
	public void shouldGenerateItemsUrl() {
		assertEquals("http://api.ft.com/content/items/v1", template.generateUrl());
	}
	
	
}
