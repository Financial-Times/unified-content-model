package com.ft.unifiedContentModel.ws.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ft.unifiedContentModel.ws.http.ResponseHeader;
import com.google.common.collect.ImmutableList;

/**
 * <p>A Servlet Filter configured with a list of {@link ResponseHeader} objects which are
 * applied to any {@link HttpServletResponse} mapped to this Filter.</p>
 *
 * @author andrew.winter
 */
public class ResponseHeaderSettingFilter extends OncePerRequestFilter {
	
	private static final Logger log = LoggerFactory.getLogger(ResponseHeaderSettingFilter.class);

	private List<ResponseHeader> responseHeaders;
	
	public ResponseHeaderSettingFilter(List<ResponseHeader> responseHeaders) {
		Assert.notEmpty(responseHeaders);
		this.responseHeaders = ImmutableList.copyOf(responseHeaders);
	}

	@Override
	protected final void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		ResponseHeaderLoggingResponseWrapper wrapped = new ResponseHeaderLoggingResponseWrapper(response);
		for (ResponseHeader responseHeader : responseHeaders) {
			responseHeader.setOn(wrapped);
		}
		filterChain.doFilter(request, wrapped);
	}
	
	private static class ResponseHeaderLoggingResponseWrapper extends HttpServletResponseWrapper {

		public ResponseHeaderLoggingResponseWrapper(HttpServletResponse response) {
			super(response);
		}
		@Override 
		public void setHeader(String name, String value) {
			logHeaderAddition(name, value);
            super.setHeader(name, value);
        }
        @Override 
        public void addHeader(String name, String value) {
			logHeaderAddition(name, value);
            super.addHeader(name, value);
        }
        
        private void logHeaderAddition(String name, String value) {
        	if (log.isDebugEnabled()) {
            	log.debug("Adding response header [" + name + " : " + value + "]");
            }
        }	
	}	
}
