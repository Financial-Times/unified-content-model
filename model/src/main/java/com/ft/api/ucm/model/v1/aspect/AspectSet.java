package com.ft.api.ucm.model.v1.aspect;

import com.ft.api.ucm.model.v1.AspectSetAware;

public interface AspectSet extends Assignable, Comparable<AspectSet> {
	
	void applyTo(AspectSetAware aspectSetAware);
	
}
