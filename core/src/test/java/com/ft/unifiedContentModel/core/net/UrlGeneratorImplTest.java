package com.ft.unifiedContentModel.core.net;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.google.common.collect.Maps;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.util.UriTemplate;

@RunWith(MockitoJUnitRunner.class)
public class UrlGeneratorImplTest {

	private static final UriTemplate ITEM_PATH = new UriTemplate(Paths.ITEM_READ);
	private static final UriTemplate PAGE_PATH = new UriTemplate(Paths.PAGE_READ);
	private static final UriTemplate COMPONENT_PATH = new UriTemplate(Paths.PAGE_CONTENT_READ);
	
	private static final String RESOLVED_ITEM_READ_PATH = "/content/items/v1/123";
	private static final String RESOLVED_COMPONENT_READ_PATH = "/site/v1/pages/123/main-content";
	private static final String RESOLVED_PAGE_READ_PATH = "/site/v1/pages/123";
	
	private static final String IMAGE_URL = "http://im.media.ft.com/content/images";
	private static final String API_URL = "http://api.ft.com";

	private static final String UUID = "123";
    private static final String IMAGE_PATH = "1234-5678.img";
    private static final String COMPONENT_VANITY = "main-content";
	
	private UrlGeneratorImpl generator;
    
    private @Mock PathFactory mockPathFactory;
    private @Mock Path mockpath;


	@Before
	public void setup() {
		generator = new UrlGeneratorImpl(API_URL, IMAGE_URL, mockPathFactory);
	}
	
	@Test
	public void itemUrl() {
		generator.setBaseApiUrl(API_URL);
		
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("itemId", UUID);
		when(mockpath.toString()).thenReturn(RESOLVED_ITEM_READ_PATH);
		when(mockPathFactory.createPath(Mockito.eq(Paths.ITEM_READ), Mockito.eq(vars))).thenReturn(mockpath);
		
		String url = generator.createUrlForItem(UUID).toString();
	
		assertEquals(API_URL + ITEM_PATH.expand(UUID), url);
	}

	@Test
	public void itemsUrl() {
		when(mockpath.toString()).thenReturn(Paths.ITEM_LIST);
		when(mockPathFactory.createPath(Mockito.eq(Paths.ITEM_LIST))).thenReturn(mockpath);
		
		String url = generator.createUrlForItems().toString();
		assertEquals(API_URL + Paths.ITEM_LIST, url);
	}

	@Test
	public void pageUrl() {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pageId", UUID);
		when(mockpath.toString()).thenReturn(RESOLVED_PAGE_READ_PATH);
		when(mockPathFactory.createPath(Mockito.eq(Paths.PAGE_READ), Mockito.eq(vars))).thenReturn(mockpath);
			
		String url = generator.createUrlForPage(UUID).toString();
		assertEquals(API_URL + PAGE_PATH.expand(UUID), url);
	}

	@Test
	public void pagesUrl() {
		when(mockpath.toString()).thenReturn(Paths.PAGE_LIST);
		when(mockPathFactory.createPath(Mockito.eq(Paths.PAGE_LIST))).thenReturn(mockpath);
		
		String url = generator.createUrlForPages().toString();
		assertEquals(API_URL + Paths.PAGE_LIST, url);
	}

	@Test
	public void imageUrl() {
		String url = generator.createUrlForImage(IMAGE_PATH).toString();
		assertEquals(IMAGE_URL + "/" + IMAGE_PATH, url);
	}

    @Test
	public void pageContentUrl() {
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pageId", UUID);
        vars.put("componentVanityId", COMPONENT_VANITY);
		when(mockpath.toString()).thenReturn(RESOLVED_COMPONENT_READ_PATH);
		when(mockPathFactory.createPath(Mockito.eq(Paths.PAGE_CONTENT_READ), Mockito.eq(vars))).thenReturn(mockpath);

		String url = generator.createUrlForContentList(UUID, COMPONENT_VANITY).toString();
		assertEquals(API_URL + COMPONENT_PATH.expand(UUID, COMPONENT_VANITY), url);
	}

    @Test
    public void contentItemNotificationsUrl(){
        when(mockpath.toString()).thenReturn(Paths.ITEM_NOTIFICATIONS_LIST);
        when(mockPathFactory.createPath(Mockito.eq(Paths.ITEM_NOTIFICATIONS_LIST))).thenReturn(mockpath);

        String url = generator.createUrlForContentItemUpdateNotifications().toString();
        assertEquals(API_URL + "/" + Paths.ITEM_NOTIFICATIONS_LIST, url);
    }

    @Test
	public void shouldCreateRequestUrlBasedOnSupplied() throws Exception {
    	String url = generator.createRequestUrl("/servlet", "/path", "param1=foo&param2=bar").toString();
    	assertEquals("http://api.ft.com/servlet/path?param1=foo&param2=bar", url);
	}

    @Test
	public void shouldCreateRequestUrlBasedOnSuppliedWithNullQueryString() throws Exception {
    	String url = generator.createRequestUrl("/servlet", "/path", null).toString();
    	assertEquals("http://api.ft.com/servlet/path", url);
	}

    @Test
	public void shouldCreateRequestUrlBasedOnSuppliedWithNullQueryStringAndNullPathInfo() throws Exception {
    	String url = generator.createRequestUrl("/servlet", null, null).toString();
    	assertEquals("http://api.ft.com/servlet", url);
	}

    @Test
	public void shouldCreateRequestUrlBasedOnSuppliedWithdNullPathInfo() throws Exception {
    	String url = generator.createRequestUrl("/servlet", null, "param1=foo&param2=bar").toString();
    	assertEquals("http://api.ft.com/servlet?param1=foo&param2=bar", url);
	}

	@Test
	public void shouldCreateItemUrlWithLastModifiedQueryParam() throws Exception {
		generator.setBaseApiUrl(API_URL);

		Map<String, Object> vars = Maps.newHashMap();
		vars.put("itemId", UUID);
		when(mockpath.toString()).thenReturn(RESOLVED_ITEM_READ_PATH);
		when(mockPathFactory.createPath(Mockito.eq(Paths.ITEM_READ), Mockito.eq(vars))).thenReturn(mockpath);

		String timestamp = "16-07-2012T13.33.56.123Z";
		String url = generator.createUrlForItemWithLastModifiedDate(UUID, "16-07-2012T13.33.56.123Z").toString();
		assertEquals(API_URL + ITEM_PATH.expand(UUID)+ "?lastModifiedDate=" + timestamp, url );
	}
}
