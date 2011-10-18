package com.ft.unifiedContentModel.ws.http;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.core.net.Host;
import com.ft.unifiedContentModel.ws.http.ServedByResponseHeader;

@RunWith(MockitoJUnitRunner.class)
public class ServedByResponseHeaderTest {
	
	private static final String HOST_NAME = "hostname";
	
	@Mock private Host mockHost;
	@Mock private HttpServletResponse mockResponse;
	
	private ServedByResponseHeader instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new ServedByResponseHeader(mockHost);
	}

	@Test
	public void hostNameSetOnResponse() {
		when(mockHost.getHostName()).thenReturn(HOST_NAME);
		instance.setOn(mockResponse);
		verify(mockResponse).addHeader(ServedByResponseHeader.SERVED_BY_HEADER_NAME, HOST_NAME);
	}
	
}
