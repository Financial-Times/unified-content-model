package com.ft.api.ucm.model.v1.aspect;

public interface FieldResolutionPolicy {

  boolean hasField(Field field, Object object);
}
