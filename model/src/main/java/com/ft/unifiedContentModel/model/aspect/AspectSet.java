package com.ft.unifiedContentModel.model.aspect;

import com.ft.unifiedContentModel.model.AspectSetAware;

public interface AspectSet extends Assignable, Comparable<AspectSet> {
	
	void applyTo(AspectSetAware aspectSetAware);
	
}
