package com.ft.api.ucm.model.v1.items.urls;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ContentItemUrlTemplateTest {
	
	private static final String BASE_API_URL = "http://api.ft.com";
	private static final String ITEM_UUID = "1234"; 
	private static final String HASH = "e40ab533"; 
	
	private ContentItemUrlTemplate template;
	
	@Before
	public void setup() {
		template = new ContentItemUrlTemplate(BASE_API_URL);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void failsWithNullBaseApiUrl() {
		new ContentItemUrlTemplate(null);
	}
	
	@Test
	public void shouldGenerateItemUrl() {
		assertEquals("http://api.ft.com/content/items/v1/1234", template.generateUrl(ITEM_UUID));
	}
	
	@Test
	public void shouldGenerateItemUrlWithHash() {
		assertEquals("http://api.ft.com/content/items/v1/1234?h=e40ab533", template.generateUrl(ITEM_UUID, HASH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldFailToGenerateWithNullItemUuid() {
		template.generateUrl(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldFailWithHashAndNullId() {
		template.generateUrl(null, HASH);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldFailWithNullHash() {
		template.generateUrl(ITEM_UUID, null);
	}

}
