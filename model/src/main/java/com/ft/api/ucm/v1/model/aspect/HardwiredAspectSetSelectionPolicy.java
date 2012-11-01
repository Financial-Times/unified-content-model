package com.ft.api.ucm.v1.model.aspect;

import java.util.Set;

import org.springframework.util.Assert;

import com.ft.api.ucm.v1.model.AspectSetAware;
import com.google.common.base.Objects;

class HardwiredAspectSetSelectionPolicy implements AspectSetSelectionPolicy {
	
	private AspectSet defaultAspectSet;
	
	public HardwiredAspectSetSelectionPolicy(AspectSet defaultAspectSet) {
		Assert.notNull(defaultAspectSet);
		this.defaultAspectSet = defaultAspectSet;
	}

	@Override
	public AspectSet match(Set<AspectSet> aspectSets, Class<? extends AspectSetAware> type) {
		return defaultAspectSet;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("defaultAspectSet", defaultAspectSet)
				.toString();
	}
}
