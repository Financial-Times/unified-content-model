package com.ft.unifiedContentModel.ws.http;

import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.ws.http.CacheControlResponseHeader;

@RunWith(MockitoJUnitRunner.class)
public class CacheControlResponseHeaderTest {
	
	private CacheControlResponseHeader header;
	

	@Mock 
	private HttpServletResponse mockResponse;
	
	@Before
	public void setup(){
		header = new CacheControlResponseHeader();
	}
	
	@Test
	public void cacheControlSetOnResponse(){
		header.setOn(mockResponse);
		verify(mockResponse).addHeader(CacheControlResponseHeader.CACHE_CONTROL_HEADER_NAME, CacheControlResponseHeader.CACHE_CONTROL_HEDAER_VALUE);
	}

}
