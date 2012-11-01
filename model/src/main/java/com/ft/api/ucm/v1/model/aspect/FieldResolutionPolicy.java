package com.ft.api.ucm.v1.model.aspect;

public interface FieldResolutionPolicy {
	
	boolean hasField(Field field, Object object);

}
