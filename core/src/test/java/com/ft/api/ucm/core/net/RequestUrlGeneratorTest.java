package com.ft.api.ucm.core.net;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class RequestUrlGeneratorTest {
	
	private RequestUrlGeneratorImpl generator;
	
	private static final String API_URL = "http://api.ft.com";
	
	@Before
	public void setup() {
		generator = new RequestUrlGeneratorImpl(API_URL);
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

}
