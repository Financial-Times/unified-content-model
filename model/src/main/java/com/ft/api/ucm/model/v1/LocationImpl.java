package com.ft.api.ucm.model.v1;

import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;

public class LocationImpl implements Location {

	private String uri;
	
	public LocationImpl(){
	}

	public LocationImpl(String uri) {
		this.uri = StringUtils.isNotBlank(uri) ? uri : null;
	}

	@Override
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri.trim();
	}

    @Override
	public String toString() {
		return Objects.toStringHelper(this).add("uri", uri).toString();
	}
	
}
