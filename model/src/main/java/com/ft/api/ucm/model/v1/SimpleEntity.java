package com.ft.api.ucm.model.v1;

import com.google.common.base.Objects.ToStringHelper;



public abstract class SimpleEntity extends IdentifiableEntity {

	private Title title;
	private Lifecycle lifecycle;

	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

	public Title getTitle() {
		return title;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}
	
	@Override
	protected ToStringHelper toStringHelper() {
		ToStringHelper toStringHelper = super.toStringHelper();
		return toStringHelper
					.add("title", title)
					.add("lifecycle", lifecycle);
	}
}
