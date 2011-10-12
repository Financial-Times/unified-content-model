package com.ft.unifiedContentModel.core.net;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import com.ft.unifiedContentModel.core.net.UrlBuilder;

import static org.apache.commons.lang.CharEncoding.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.springframework.web.util.UriUtils.encodeHttpUrl;

public class UrlBuilderTest {
	
	private static final String SCHEME = "http";
	private static final String SECURE_SCHEME = "https";
	private static final String SERVER_NAME = "localhost";
	private static final String NON_STANDARD_PORT = "8080";
	private static final int DEFAULT_HTTP_PORT = 80;
	private static final int DEFAULT_HTTPS_PORT = 443;
	private static final String SERVLET_PATH = "/1234567/resource";
	private static final String SERVLET_PATH_WITH_SPECIAL_CHARS = "/[SPECIAL]/resource";
	private static final String QUERY_STRING = "limit=5&offset=0";
	private static final String NEW_SERVLET_PATH = "/test/success";
	
	private static final String EXPECTED_URL_STRING = SCHEME + "://" + SERVER_NAME + ":" + NON_STANDARD_PORT + SERVLET_PATH; 
	
	@Test
	public void basedOnExistingRequest() {
    	assertEquals(EXPECTED_URL_STRING, UrlBuilder.basedOn(newRequest(), false).toString());
	}
	
	@Test
	public void basedOnExistingRequestIncludingParams() {
		MockHttpServletRequest request = newRequest();
		request.setQueryString(QUERY_STRING);
    	assertEquals(EXPECTED_URL_STRING + '?' + QUERY_STRING, UrlBuilder.basedOn(request, true).toString());
	}
	
	@Test
	public void basedOnExistingRequestIncludingParamsWhereNotNull() {
		MockHttpServletRequest request = newRequest();
		request.setQueryString(null);
    	assertEquals(EXPECTED_URL_STRING, UrlBuilder.basedOn(request, true).toString());
	}
	
	@Test
	public void basedOnStringUrl() {
		String baseUrl = "http://int.media.ft.com/content/images?true=false";
    	assertEquals(baseUrl, UrlBuilder.basedOn(baseUrl).toString());
	}
	
	@Test
	public void withNewPath() {
    	assertEquals(SCHEME + "://" + SERVER_NAME + ":" + NON_STANDARD_PORT + NEW_SERVLET_PATH, 
    															UrlBuilder.basedOn(newRequest(), false)
    															.withPath(NEW_SERVLET_PATH)
    															.toString());
	}
	
	@Test
	public void specialCharsEncoded() throws Exception {
    	assertEquals(encodeHttpUrl(SCHEME + "://" + SERVER_NAME + ":" + NON_STANDARD_PORT + SERVLET_PATH_WITH_SPECIAL_CHARS, UTF_8), 
    															UrlBuilder.basedOn(newRequest(), false).withPath(NEW_SERVLET_PATH)
    															.withPath(SERVLET_PATH_WITH_SPECIAL_CHARS)
    															.toString());
	}
	
	@Test
	public void withRootContextPath() {
		MockHttpServletRequest request = newRequest();
		request.setContextPath("/");
    	assertEquals(SCHEME + "://" + SERVER_NAME + ":" + NON_STANDARD_PORT + SERVLET_PATH, 
    															UrlBuilder.basedOn(request, false).toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void withNullRequest() {
		UrlBuilder.basedOn(null, false);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void withInvalidScheme() {
		UrlBuilder.basedOn(newRequest(), false).withScheme("httttttttppppddd");
	}
	
	@Test
	public void withNegativePortCorrected() {
		assertEquals(SCHEME + "://" + SERVER_NAME + SERVLET_PATH, 
																UrlBuilder.basedOn(newRequest(), false)
																		.withPort(-20)
																		.toString());
	}
	
	@Test
	public void withZeroPortCorrected() {
		assertEquals(SCHEME + "://" + SERVER_NAME + SERVLET_PATH, 
																UrlBuilder.basedOn(newRequest(), false)
																		.withPort(0)
																		.toString());
	}
	
	@Test
	public void defaultHttpPortNotWritten() {
		assertEquals(SCHEME + "://" + SERVER_NAME + SERVLET_PATH, 
																UrlBuilder.basedOn(newRequest(), false)
																		.withPort(DEFAULT_HTTP_PORT)
																		.toString());
	}
	
	@Test
	public void defaultHttpsPortNotWritten() {
		assertEquals(SECURE_SCHEME + "://" + SERVER_NAME + SERVLET_PATH, 
																UrlBuilder.basedOn(newRequest(), false)
																		.withPort(DEFAULT_HTTPS_PORT)
																		.withScheme(SECURE_SCHEME)
																		.toString());
	}


    @Test
	public void overridePaths() {
		assertEquals(SCHEME + "://" + SERVER_NAME + "/newServletPath",
																UrlBuilder.basedOn(newRequest(), false)
                                                                        .withPort(DEFAULT_HTTP_PORT)
																		.overridePaths("/newServletPath")
																		.toString());
	}

	private MockHttpServletRequest newRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setScheme(SCHEME);
		request.setServerName(SERVER_NAME);
		request.setServerPort(Integer.parseInt(NON_STANDARD_PORT));
		request.setServletPath(SERVLET_PATH);
		return request;
	}
	
}
