package com.ft.unifiedContentModel.core.net;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UrlPathHelper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

public class CurrentRequest implements Request {

	private UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Autowired
	private HttpServletRequest request;

	protected String getExtensionFromFilename(String filename) {
		return StringUtils.getFilenameExtension(filename);
	}

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public HttpServletRequest getRequest() {
        return request;
    }


    public void setUrlPathHelper(UrlPathHelper urlPathHelper) {
        this.urlPathHelper = urlPathHelper;
    }

    @Override
    public String getFormat() {
        String requestUri = urlPathHelper.getRequestUri(request);
		String filename = WebUtils.extractFullFilenameFromUrlPath(requestUri);
		return getExtensionFromFilename(filename);
    }
}
