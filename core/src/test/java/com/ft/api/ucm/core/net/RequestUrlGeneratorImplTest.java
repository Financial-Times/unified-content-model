package com.ft.api.ucm.core.net;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class RequestUrlGeneratorImplTest {
	
	private RequestUrlGeneratorImpl generator;
	
	private static final String API_URL = "http://api.ft.com";
	
	@Before
	public void setup() {
		generator = new RequestUrlGeneratorImpl(API_URL);
	}
	
	@Test
    public void shouldCreateRequestUrlBasedOnSuppliedDefault() throws Exception {
        String url = generator.createRequestUrl("/servlet", "/path", "param1=foo&param2=bar").toString();
        assertEquals("http://api.ft.com/servlet/path?param1=foo&param2=bar", url);
    }
	
    @Test
    public void shouldCreateRequestUrlBasedOnSuppliedHttpsWithPort() throws Exception {
        generator = new RequestUrlGeneratorImpl(API_URL + ":8080");
        String url = generator.createRequestUrl(HttpProtocol.HTTPS, "/servlet", "/path", "param1=foo&param2=bar").toString();
        assertEquals("https://api.ft.com:8080/servlet/path?param1=foo&param2=bar", url);
    }
	
	@Test
	public void shouldCreateRequestUrlBasedOnSuppliedHttp() throws Exception {
		String url = generator.createRequestUrl(HttpProtocol.HTTP, "/servlet", "/path", "param1=foo&param2=bar").toString();
		assertEquals("http://api.ft.com/servlet/path?param1=foo&param2=bar", url);
	}
	
   @Test
    public void shouldCreateRequestUrlBasedOnSuppliedHttps() throws Exception {
        String url = generator.createRequestUrl(HttpProtocol.HTTPS, "/servlet", "/path", "param1=foo&param2=bar").toString();
        assertEquals("https://api.ft.com/servlet/path?param1=foo&param2=bar", url);
    }

	@Test
	public void shouldCreateRequestUrlBasedOnSuppliedWithNullQueryString() throws Exception {
		String url = generator.createRequestUrl("/servlet", "/path", null).toString();
		assertEquals("http://api.ft.com/servlet/path", url);
	}

	@Test
	public void shouldCreateRequestUrlBasedOnSuppliedWithNullQueryStringAndNullPathInfo()
			throws Exception {
		String url = generator.createRequestUrl("/servlet", null, null).toString();
		assertEquals("http://api.ft.com/servlet", url);
	}

	@Test
	public void shouldCreateRequestUrlBasedOnSuppliedWithdNullPathInfo() throws Exception {
		String url = generator.createRequestUrl("/servlet", null, "param1=foo&param2=bar").toString();
		assertEquals("http://api.ft.com/servlet?param1=foo&param2=bar", url);
	}

	@Test
	public void shouldStripApiKeyParameterByDefault() throws Exception {
		String url = generator.createRequestUrl("/servlet", null, "foo=bar&apiKey=12345").toString();
		assertEquals("Expected 'blacklistedparam' to be stripped", "http://api.ft.com/servlet?foo=bar", url);
	}
	
	@Test
	public void shouldStripBlacklistedParameter() throws Exception {
		generator.addBlacklistedParameter("blacklistedparam");
		String url = generator.createRequestUrl("/servlet", null, "foo=bar&blacklistedparam=danger&foo=bar").toString();
		assertEquals("Expected 'blacklistedparam' to be stripped", "http://api.ft.com/servlet?foo=bar&foo=bar", url);
	}

	@Test
	public void shouldStripMultipleBlacklistedParameters() throws Exception {
		generator.addBlacklistedParameter("blacklistedparam");
		String url = generator.createRequestUrl("/servlet", null, "blacklistedparam=danger&blacklistedparam=moredanger").toString();
		assertEquals("Expected 'blacklistedparam' to be stripped", "http://api.ft.com/servlet", url);
	}

	@Test
	public void shouldStripMultipleBlacklistedParameterNames() throws Exception {
		generator.addBlacklistedParameter("blacklistedparam1");
		generator.addBlacklistedParameter("blacklistedparam2");
		String url = generator.createRequestUrl("/servlet", null, "blacklistedparam1=danger&blacklistedparam2=moredanger").toString();
		assertEquals("Expected 'blacklistedparam' to be stripped", "http://api.ft.com/servlet", url);
	}

	@Test
	public void shouldStripMultipleBlacklistedParameterNamesWithWhitespace() throws Exception {
		generator.addBlacklistedParameter("blacklistedparam1");
		generator.addBlacklistedParameter("blacklistedparam2");
		String url = generator.createRequestUrl("/servlet", null, "blacklistedparam1=danger&blacklistedparam2=more%20danger").toString();
		assertEquals("Expected 'blacklistedparam' to be stripped", "http://api.ft.com/servlet", url);
	}

}
