package com.ft.api.ucm.model.v1;

import com.ft.api.ucm.model.v1.version.Version;
import com.google.common.base.Objects;

public abstract class IdentifiableEntity implements Identifiable, Versionable, Retrievable {

	private String id;
	private String apiUrl;
	private String modelVersion = Version.ONE.toString();
	
	public IdentifiableEntity() {
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String getApiUrl() {
		return apiUrl;
	}
	
	@Override
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	@Override
	public String getModelVersion() {
		return modelVersion;
	}
	
	public void setModelVersion(String version) {
		this.modelVersion = version;
	}
	
    @Override
	public String toString() {
        return toStringHelper().toString();
    }

    protected Objects.ToStringHelper toStringHelper() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("modelVersion", modelVersion)
                .add("apiUrl", apiUrl);
    }
}
