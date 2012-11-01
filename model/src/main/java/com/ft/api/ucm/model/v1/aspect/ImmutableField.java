package com.ft.api.ucm.model.v1.aspect;

import static org.springframework.util.Assert.notNull;

public final class ImmutableField implements Field {

	private final String name;
	private final FieldResolutionPolicy fieldResolutionPolicy;
	 
	private ImmutableField(String name, FieldResolutionPolicy fieldResolutionPolicy) {
		notNull(name);
		notNull(fieldResolutionPolicy);
		this.name = name;
		this.fieldResolutionPolicy = fieldResolutionPolicy;
	}
	
	public static ImmutableField valueOf(String name, FieldResolutionPolicy fieldResolutionPolicy) {
		return new ImmutableField(name, fieldResolutionPolicy);
	}
	
	@Override
	public boolean assignableFrom(Object object) {
		return containsField(object);
	}

	private boolean containsField(Object object) {
		return fieldResolutionPolicy.hasField(this, object);
	}
	
	@Override
	public boolean equals(Object that) {
	  if (this == that) {
        return true;
      }
      if (!(that instanceof ImmutableField)) {
        return false;
      }
      ImmutableField thatField = (ImmutableField) that;
      return toString().equals(thatField.toString());
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public int compareTo(Field that) {
		return toString().compareTo(that.toString());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
