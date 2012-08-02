package com.ft.unifiedContentModel.ws.http;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.util.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpiresResponseHeaderTest {

	private ExpiresResponseHeader header;
	

	@Mock 
	private HttpServletResponse mockResponse;
	@Mock private HttpServletRequest mockRequest;
	
	@Before
	public void setup(){
		header = new ExpiresResponseHeader();
	}
	
	@Test
	public void cacheControlSetOnResponse(){
		header.setOn(mockResponse, mockRequest);
		verify(mockResponse).addHeader(eq(ExpiresResponseHeader.EXPIRES_HEADER_NAME), any(String.class));
	}
	
	@Test
	public void expiryDateIsInRFC1123Format() throws Exception{
		String returned = header.getExpiryDate();
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.PATTERN_RFC1123);
		Date date = sdf.parse(returned);
		assertNotNull(date);
	}
}
