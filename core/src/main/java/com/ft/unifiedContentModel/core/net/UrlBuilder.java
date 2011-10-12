package com.ft.unifiedContentModel.core.net;

import static org.apache.commons.lang.CharEncoding.UTF_8;
import static org.apache.commons.lang.StringUtils.isNotBlank;
import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.removeStart;
import static org.springframework.util.Assert.notNull;
import static org.springframework.web.util.UriUtils.encodeHttpUrl;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;


/**
 * <p>Internal class for building URLs based on a {@link RequestUrl}
 * or an {@link HttpServletRequest}.</p>
 * 
 * @author andrew.winter
 */
public final class UrlBuilder {
	
	private static final String SLASH = "/";
    private static final String DOT = ".";
	private static final String HTTP = "http";
	private static final String HTTPS = "https";

    private String scheme;
    private String serverName;
    private int port;
    private String contextPath;
    private String servletPath;
    private String pathInfo;
    private String query;
    private String requestFormat;
    
    private UrlBuilder(URI uri) {
    	withScheme(uri.getScheme());
    	withServerName(uri.getHost());
    	withPort(uri.getPort());
    	withPath(uri.getPath());
    	appendToQuery(uri.getQuery());
    }
    
    private UrlBuilder(HttpServletRequest request, boolean includeParameters) {
    	withScheme(request.getScheme());
    	withServerName(request.getServerName());
    	withPort(request.getServerPort());
    	withPath(request.getServletPath());
    	withPathInfo(request.getPathInfo());
    	if (includeParameters) {
        	appendToQuery(request.getQueryString());
    	}
    }
    
    /** Create a new UrlBuilder from an HttpServletRequest */
    public static UrlBuilder basedOn(HttpServletRequest request, boolean includeParameters) {
    	notNull(request);
    	return new UrlBuilder(request, includeParameters);
    }
    
    /**
     * Create a new UrlBuilder from a String Url.
     * 
     * @throws IllegalArgumentException thrown if the given baseUrl is not well formed
     */
    public static UrlBuilder basedOn(String baseUrl) {
    	return new UrlBuilder(URI.create(baseUrl));
    }
    
    public UrlBuilder withPath(String servletPath) {
        this.servletPath = servletPath;
        return this;
    }

    public UrlBuilder overridePaths(String servletPath) {
        this.pathInfo = "";
        this.servletPath = servletPath;
        return this;
    }

    public UrlBuilder withScheme(String scheme) {
    	Assert.isTrue(HTTP.equalsIgnoreCase(scheme) || HTTPS.equalsIgnoreCase(scheme));
        this.scheme = scheme.toLowerCase();
        return this;
    }

    public UrlBuilder withServerName(String serverName) {
        this.serverName = serverName;
        return this;
    }

    public UrlBuilder withPort(int port) {
    	if (port <= 0) {
            port = 80; // Work around java.net.URL bug
        }
        this.port = port;
        return this;
    }

    public UrlBuilder withContextPath(String contextPath) {
        this.contextPath = contextPath;
        return this;
    }

    public UrlBuilder withPathInfo(String pathInfo) {
        this.pathInfo = pathInfo;
        return this;
    }
    
    public UrlBuilder withQueryParameter(String strKey, String strValue){
    	appendToQuery(strKey);
    	query = "=" + strValue;
    	return this;
    } 

	public Url build() {
    	StringBuilder sb;
    	if (StringUtils.isNotEmpty(scheme) && StringUtils.isNotEmpty(serverName)) {
    		sb = createServerStringBuilder(scheme, serverName, port);
    	} else {
    		sb = new StringBuilder();
    	}
        if (isNotBlank(contextPath)) {
            sb.append(contextPath);
        }

        if (isNotBlank(servletPath)) {
        	if (SLASH.equals(contextPath)) {
        		servletPath = removeStart(servletPath, SLASH);
        	}
            sb.append(servletPath);
        }

        if (isNotBlank(pathInfo)) {
        	if (!StringUtils.startsWith(pathInfo, SLASH)) {
        		sb.append(SLASH);
        	}
            sb.append(pathInfo);
        }

        if (isNotBlank(requestFormat)) {
            sb.append(DOT).append(requestFormat);
        }

        if (isNotBlank(query)) {
            sb.append(query);
        }
        try {
			return new Url(encodeHttpUrl(sb.toString(), UTF_8));
		} catch (UnsupportedEncodingException ex) {
			// Should never happen - UTF-8 is always supported
			throw new IllegalStateException("Could not create HTTP URL from [" + sb.toString() + "]: " + ex, ex);
		}
    }
	
	@Override
	public String toString() {
		return build().toString();
	}
    
    /** Return StringBuffer representing the scheme, server, and port number of the current request.*/
    private StringBuilder createServerStringBuilder(String scheme, String server, int port) {
    	StringBuilder url = new StringBuilder().append(scheme).append("://").append(server);
    	return appendPortIfNotStandardForScheme(url);
    }
    
    private StringBuilder appendPortIfNotStandardForScheme(StringBuilder url) {
    	if ((scheme.equals(HTTP) && (port != 80)) || (scheme.equals(HTTPS) && (port != 443))) {
            url.append(':');
            url.append(port);
        }
    	return url;
    }
    
    private void appendToQuery(String text) {
    	if (isNotEmpty(text)) { 
    		if(isNotEmpty(query)){
        		query = "&" + text;
        	} else {
        		query = "?" + text;
        	}
    	}
    }
}
