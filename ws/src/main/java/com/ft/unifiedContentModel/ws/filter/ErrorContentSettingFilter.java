package com.ft.unifiedContentModel.ws.filter;
        

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * <p>A Servlet Filter sets the desired content for statusCode >= 400</p>
 *
 * @author alberto.faci
 */
public class ErrorContentSettingFilter extends OncePerRequestFilter {
	
	private Map<String, String> mediaTypesMap;
	private String defaultContentType;
	
	public ErrorContentSettingFilter(Map<String, String> mediaTypesMap, String defaultContentType) {
		Assert.notEmpty(mediaTypesMap);
		Assert.notNull(defaultContentType);
		this.mediaTypesMap = mediaTypesMap;
		this.defaultContentType = defaultContentType;
	}

	@Override
	protected final void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		ContentResponseWrapper wrapper = new ContentResponseWrapper(request, response, mediaTypesMap, defaultContentType);
		filterChain.doFilter(request, wrapper);
	}
	
	static class ContentResponseWrapper extends HttpServletResponseWrapper {
		
		private HttpServletRequest request;
		private Map<String, String> mediaTypes;
		private String defaultContentType;
		
		public ContentResponseWrapper(HttpServletRequest request, HttpServletResponse response, Map<String, String> mediaTypesMap, String defaultContentType) {
			super(response);
			this.request = request;
			this.mediaTypes = mediaTypesMap;
			this.defaultContentType = defaultContentType;
		}
		
		@Override
		public void setStatus(int sc) {
			this.setStatus(sc, null);
		}

		@Override
		public void setStatus(int sc, String sm) {
			if (isStatusError(sc)) {
				super.getResponse().setContentLength(0);
				setContentTypeFromRequest();
			}
			super.setStatus(sc, sm);
		}

		public void setContentTypeFromRequest() {
			super.setContentType(resolveContentTypeFromRequest(request));
		}
				
		private boolean isStatusError(int sc) {
			HttpStatus.Series series = HttpStatus.valueOf(sc).series();
			return (series == HttpStatus.Series.CLIENT_ERROR)
					|| (series == HttpStatus.Series.SERVER_ERROR);
		}
		
		private String resolveContentTypeFromRequest(HttpServletRequest request) {
			for(Map.Entry<String, String> e: mediaTypes.entrySet()) {
				if(request.getRequestURI().contains("."+e.getKey())) {
					return e.getValue();
				}
			}
			return defaultContentType;
		}
       
    }
	
}
