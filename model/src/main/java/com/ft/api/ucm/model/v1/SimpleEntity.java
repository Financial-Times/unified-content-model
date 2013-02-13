package com.ft.api.ucm.model.v1;

import com.google.common.base.Objects.ToStringHelper;



public abstract class SimpleEntity extends IdentifiableEntity {

	private Title title;
	private Lifecycle lifecycle;
	private Nature nature;

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
	
	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	@Override
	protected ToStringHelper toStringHelper() {
		ToStringHelper toStringHelper = super.toStringHelper();
		return toStringHelper
					.add("title", title)
					.add("lifecycle", lifecycle)
					.add("nature", nature);
	}
}
