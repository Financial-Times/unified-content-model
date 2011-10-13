package com.ft.unifiedContentModel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.common.base.Objects.ToStringHelper;


@XmlTransient
public abstract class SimpleEntity extends IdentifiableEntity {

	private Title title;
	private Lifecycle lifecycle;
	
	@XmlElement(name="lifecycle", namespace=XSDs.ASPECT_NAMESPACE)
	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

	@XmlElement(name="title", namespace=XSDs.ASPECT_NAMESPACE)
	public Title getTitle() {
		return title;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}
	
	@Override
	protected ToStringHelper toStringHelper() {
		return super.toStringHelper()
					.add("title", title)
					.add("lifecycle", lifecycle);
	}
}
