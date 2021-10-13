package com.ft.api.ucm.core.net;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.removeStart;
import static org.springframework.util.Assert.notNull;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Internal class for building URLs based on a {@link URL} or an {@link HttpServletRequest}.
 *
 * @author andrew.winter
 */
public final class UrlBuilder {

  private static final int DEFAULT_HTTPS_PORT = 443;
  private static final int DEFAULT_HTTP_PORT = 80;
  private static final int DEFAULT_PORT = 80;
  private static final String SLASH = "/";
  private static final String HTTP = "http";
  private static final String HTTPS = "https";

  private String scheme;
  private String serverName;
  private int port;
  private String contextPath;
  private String servletPath;
  private String pathInfo;
  private String query;

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
    notNull(request, "request should not be null");
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
    Assert.isTrue(
        HTTP.equalsIgnoreCase(scheme) || HTTPS.equalsIgnoreCase(scheme),
        "scheme should be http or https");
    this.scheme = scheme.toLowerCase();
    return this;
  }

  public UrlBuilder withServerName(String serverName) {
    this.serverName = serverName;
    return this;
  }

  public UrlBuilder withPort(int port) {
    if (port <= 0) {
      this.port = DEFAULT_PORT; // Work around java.net.URL bug
    } else {
      this.port = port;
    }
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

  public UrlBuilder withQueryParameter(String strKey, String strValue) {
    appendToQuery(String.format("%s=%s", strKey, strValue));
    return this;
  }

  public UrlBuilder withQueryString(String queryString) {
    appendToQuery(queryString);
    return this;
  }

  public String uncheckedBuild() {
    StringBuilder sb;
    if (StringUtils.isNotEmpty(scheme) && StringUtils.isNotEmpty(serverName)) {
      sb = createServerStringBuilder(scheme, serverName);
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

    if (isNotBlank(query)) {
      sb.append(query);
    }
    UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(sb.toString()).build();
    String encodedUri = uriComponents.encode().toUriString();
    return encodedUri;
  }

  public String build() {
    String url = uncheckedBuild();
    try {
      new URL(url);
      return url;
    } catch (MalformedURLException e) {
      throw new IllegalStateException("There was an error building the url", e);
    }
  }

  @Override
  public String toString() {
    return uncheckedBuild();
  }

  /**
   * Return StringBuffer representing the scheme, server, and port number of the current request.
   */
  private StringBuilder createServerStringBuilder(String scheme, String server) {
    StringBuilder url = new StringBuilder().append(scheme).append("://").append(server);
    return appendPortIfNotStandardForScheme(url);
  }

  private StringBuilder appendPortIfNotStandardForScheme(StringBuilder url) {
    if ((scheme.equals(HTTP) && (port != DEFAULT_HTTP_PORT))
        || (scheme.equals(HTTPS) && (port != DEFAULT_HTTPS_PORT))) {
      url.append(':');
      url.append(port);
    }
    return url;
  }

  private void appendToQuery(String text) {
    if (isNotEmpty(text)) {
      if (isNotEmpty(query)) {
        query = "&" + text;
      } else {
        query = "?" + text;
      }
    }
  }
}
