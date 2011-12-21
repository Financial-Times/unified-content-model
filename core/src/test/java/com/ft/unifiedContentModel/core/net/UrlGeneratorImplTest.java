package com.ft.unifiedContentModel.core.net;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.util.UriTemplate;

import com.google.common.collect.Maps;

@RunWith(MockitoJUnitRunner.class)
public class UrlGeneratorImplTest {

	private static final UriTemplate ITEM_PATH = new UriTemplate(Paths.ITEM_READ);
	private static final UriTemplate PAGE_PATH = new UriTemplate(Paths.PAGE_READ);
	private static final UriTemplate COMPONENT_PATH = new UriTemplate(Paths.COMPONENT_READ);
	
	private static final String RESOLVED_ITEM_READ_PATH = "/content/items/v1/123";
	private static final String RESOLVED_COMPONENT_READ_PATH = "/structure/pages/123/components/456";
	private static final String RESOLVED_PAGE_READ_PATH = "/structure/pages/123";
	
	private static final String IMAGE_URL = "http://im.media.ft.com/content/images";
	private static final String API_URL = "http://api.ft.com";

	private static final String UUID = "123";
	private static final String ANOTHER_UUID = "456";
	private static final String IMAGE_PATH = "1234-5678.img";
	
	private UrlGeneratorImpl instance;
    
    private @Mock PathFactory pathFactory;
    private @Mock Path path;


	@Before
	public void setup() {
		instance = new UrlGeneratorImpl(API_URL, IMAGE_URL, pathFactory);
        
	}
	
	
	@Test
	public void itemUrl() {
		instance.setBaseApiUrl(API_URL);
		
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("itemId", UUID);
		when(path.toString()).thenReturn(RESOLVED_ITEM_READ_PATH);
		when(pathFactory.createPath(Mockito.eq(Paths.ITEM_READ), Mockito.eq(vars))).thenReturn(path);
		
		String url = instance.createUrlForItem(UUID).toString();
	
		assertEquals(API_URL + ITEM_PATH.expand(UUID), url);
	}

	

	@Test
	public void itemsUrl() {
		when(path.toString()).thenReturn(Paths.ITEM_LIST);
		when(pathFactory.createPath(Mockito.eq(Paths.ITEM_LIST))).thenReturn(path);
		
		String url = instance.createUrlForItems().toString();
		assertEquals(API_URL + Paths.ITEM_LIST, url);
	}

	@Test
	public void pageUrl() {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pageId", UUID);
		when(path.toString()).thenReturn(RESOLVED_PAGE_READ_PATH);
		when(pathFactory.createPath(Mockito.eq(Paths.PAGE_READ), Mockito.eq(vars))).thenReturn(path);
			
		String url = instance.createUrlForPage(UUID).toString();
		assertEquals(API_URL + PAGE_PATH.expand(UUID), url);
	}

	@Test
	public void pagesUrl() {
		when(path.toString()).thenReturn(Paths.PAGE_LIST);
		when(pathFactory.createPath(Mockito.eq(Paths.PAGE_LIST))).thenReturn(path);
		
		String url = instance.createUrlForPages().toString();
		assertEquals(API_URL + Paths.PAGE_LIST, url);
	}

	@Test
	public void imageUrl() {
		String url = instance.createUrlForImage(IMAGE_PATH).toString();
		assertEquals(IMAGE_URL + "/" + IMAGE_PATH, url);
	}

}
