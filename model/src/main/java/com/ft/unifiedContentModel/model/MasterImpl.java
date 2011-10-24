package com.ft.unifiedContentModel.model;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

@XmlType(name="master", namespace=XSDs.ASPECT_NAMESPACE, propOrder={"masterSource", "masterEntityId"})
public class MasterImpl implements Master {

	private String masterEntityId;
	private MasterSource masterSource;
	
	public MasterImpl() {
	}

	public MasterImpl(String masterEntityId, MasterSource masterSource){
		notNull(masterSource);
		hasText(masterEntityId);
		this.masterEntityId = masterEntityId;
		this.masterSource = masterSource;
	}
	
	@Override
	@XmlElement(name="masterSource", required=true, namespace=XSDs.FIELD_NAMESPACE)
	public String getMasterSource() {
		return masterSource.toString();
	}

	public void setMasterEntityId(String masterEntityId) {
		this.masterEntityId = masterEntityId;
	}
	
	@Override
	@XmlElement(name="masterEntityId", required=true, namespace=XSDs.FIELD_NAMESPACE)
	public String getMasterEntityId() {
		return masterEntityId;
	}

	public void setMasterSource(String masterSource) {
		this.masterSource = MasterSource.fromString(masterSource);
	}

    @Override
	public String toString() {
		return Objects.toStringHelper(this)
						.add("masterSource", masterSource)
						.add("masterEntityId", masterEntityId)
						.toString();
	}

}
