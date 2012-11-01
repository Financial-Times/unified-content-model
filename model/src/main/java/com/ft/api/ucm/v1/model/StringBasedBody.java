package com.ft.api.ucm.v1.model;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import com.google.common.base.Objects;

public class StringBasedBody implements com.ft.api.ucm.v1.model.Body {

	private String body;
    private String mediaType;

	public StringBasedBody(){
	}

    public StringBasedBody(String body, String mediaType) {
        this.body = isNotBlank(body) ? body : null;
        this.mediaType = isNotBlank(mediaType) ? mediaType : null;
    }

    @Override
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

    @Override
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Override
	public boolean equals(Object that) {
        if(that == null){
			return false;
		}
		if(that == this){
			return true;
		}
		if(that instanceof StringBasedBody) {
            StringBasedBody thatBody = (StringBasedBody) that;

			return (Objects.equal(thatBody.getBody(), this.body) &&
                    Objects.equal(thatBody.getMediaType(), this.mediaType));
        }
		return false;
	}

	@Override
	public int hashCode() {
        return Objects.hashCode(body);
	}
	
	@Override
	public String toString() {
		return body;
	}
	
}
