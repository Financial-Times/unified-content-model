package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.ft.unifiedContentModel.model.version.Version;
import com.google.common.base.Objects;

@XmlTransient
public abstract class IdentifiableEntity implements Identifiable, Versionable, Retrievable {

	private String id;
	private String apiUrl;
	private String modelVersion = Version.ONE.toString();
	
	public IdentifiableEntity() {
	}
	
	@Override
	@XmlElement(name="id", required=true)
	public String getId() {
		return id;
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	@XmlElement(name="apiUrl", required=true)
	public String getApiUrl() {
		return apiUrl;
	}
	
	@Override
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	@Override
	@XmlElement(name="modelVersion", required=true)
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
