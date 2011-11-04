package com.ft.unifiedContentModel.ws.filter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.PassThroughFilterChain;

import com.ft.unifiedContentModel.ws.filter.HttpErrorStatusLoggingFilter;
import com.ft.unifiedContentModel.ws.filter.HttpErrorStatusLoggingFilter.HttpErrorStatusLoggingResponseWrapper;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;

@RunWith(MockitoJUnitRunner.class)
public class HttpErrorStatusLoggingFilterTest {
	
	private static final int INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
	private static final String INTERNAL_SERVER_ERROR_MSG = "500 Internal Server Error";
	private static final String REQUEST_URI = "/content/items"; 
	private static final String QUERY_STRING = "query.queryString=test";
	private static final Map<String, String> REQUEST_HEADER_MAP;
	static {
		REQUEST_HEADER_MAP = Maps.newHashMap();
		REQUEST_HEADER_MAP.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		REQUEST_HEADER_MAP.put("Accept-Language", "en-gb,en;q=0.5");
		REQUEST_HEADER_MAP.put("Accept-Encoding", "gzip, deflate");
	}

	@Mock private Appender mockAppender;
	@Mock private HttpServletResponse mockResponse;
	
	private MockHttpServletRequest mockRequest;
	private MockFilterChain mockFilterChain;

	private HttpErrorStatusLoggingFilter instance;
	
	@Before
	public void setUp() throws Exception {
		setupLog4jWithMockAppender();
		instance = new HttpErrorStatusLoggingFilter();
		mockFilterChain = new MockFilterChain();
		mockRequest = new MockHttpServletRequest();
	}
	
	@After
	public void tearDown() {
		removeLog4jMockAppender();
	}

	@Test
	public void requestWrapped() throws Exception {
		instance.doFilter(mockRequest, mockResponse, mockFilterChain);
		assertTrue(mockFilterChain.getResponse() instanceof HttpErrorStatusLoggingResponseWrapper);
	}
	
	@Test
	public void logEventCreatedWhenSendingError() throws Exception {
		PassThroughFilterChain chain = new PassThroughFilterChain(instance, new PassThroughFilterChain(new ErrorSendingHttpServlet()));
		setupRequestData();
		instance.doFilter(mockRequest, mockResponse, chain);
		verifyAndAssertLogInterations();
	}
	
	private void setupRequestData() {
		Map<String, String> requestHeaderMap = REQUEST_HEADER_MAP;
		for (Map.Entry<String, String> requestHeaderPair : requestHeaderMap.entrySet()) {
			mockRequest.addHeader(requestHeaderPair.getKey(), requestHeaderPair.getValue());
		}
		mockRequest.setRequestURI(REQUEST_URI);
		mockRequest.setQueryString(QUERY_STRING);
	}

	private void verifyAndAssertLogInterations() {
		ArgumentCaptor<LoggingEvent> argument = ArgumentCaptor.forClass(LoggingEvent.class);
		verify(mockAppender).doAppend(argument.capture());
		assertEquals(expectedLogMessage(), argument.getValue().getMessage());
	}
	
	private String expectedLogMessage() {
		return new StringBuilder("[")
		   .append("errorCode=")
		   .append(INTERNAL_SERVER_ERROR).append(", ")
		   .append("errorMessage=")
		   .append(INTERNAL_SERVER_ERROR_MSG).append(", ")
		   .append("url=")
		   .append(REQUEST_URI).append(", ")
		   .append("queryString=")
		   .append(QUERY_STRING).append(", ")
		   .append("IP=")
		   .append(MockHttpServletRequest.DEFAULT_SERVER_ADDR).append(", ")
		   .append("headers=")
		   .append(Multimaps.forMap(REQUEST_HEADER_MAP))
		   .append("]")
		   .toString();
	}

	private void setupLog4jWithMockAppender() {
		Logger root = Logger.getRootLogger();
		root.setLevel(Level.ERROR);
		root.addAppender(mockAppender);
	}

	private void removeLog4jMockAppender() {
		Logger root = Logger.getRootLogger();
		root.removeAppender(mockAppender);
	}
	
	private static class ErrorSendingHttpServlet implements Servlet {
		@Override
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			((HttpServletResponse) res).sendError(INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MSG);
		}
		
		@Override
		public void init(ServletConfig config) throws ServletException {
		}

		@Override
		public ServletConfig getServletConfig() {
			return null;
		}

		@Override
		public String getServletInfo() {
			return null;
		}

		@Override
		public void destroy() {
		}
	}
}
