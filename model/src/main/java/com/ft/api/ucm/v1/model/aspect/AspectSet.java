package com.ft.api.ucm.v1.model.aspect;

import com.ft.api.ucm.v1.model.AspectSetAware;

public interface AspectSet extends Assignable, Comparable<AspectSet> {
	
	void applyTo(AspectSetAware aspectSetAware);
	
}
