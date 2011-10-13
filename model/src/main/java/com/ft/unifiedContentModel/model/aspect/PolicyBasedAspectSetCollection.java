package com.ft.unifiedContentModel.model.aspect;

import static org.springframework.util.Assert.notNull;

import java.util.Set;

import com.ft.unifiedContentModel.model.AspectSetAware;
import com.google.common.base.Objects;

public class PolicyBasedAspectSetCollection implements AspectSetCollection {
	
	private AspectSetSelectionPolicy aspectSetSelectionPolicy;
	private Set<AspectSet> aspectSets;
	
	public PolicyBasedAspectSetCollection(Set<AspectSet> aspectSets, AspectSetSelectionPolicy aspectSetSelectionPolicy) {
		notNull(aspectSets);
		notNull(aspectSetSelectionPolicy);
		this.aspectSets = aspectSets;
		this.aspectSetSelectionPolicy = aspectSetSelectionPolicy;
	}
	
	@Override
	public void applyTo(AspectSetAware aspectSetAware) {
		AspectSet aspectSet = getAspectSetByType(aspectSetAware.getClass());
		aspectSet.applyTo(aspectSetAware);
	}
	
	private AspectSet getAspectSetByType(Class<? extends AspectSetAware> type) {
		return aspectSetSelectionPolicy.match(aspectSets, type);
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("aspectSets", aspectSets)
				.add("aspectSetSelectionPolicy", aspectSetSelectionPolicy)
				.toString();
	}

}
