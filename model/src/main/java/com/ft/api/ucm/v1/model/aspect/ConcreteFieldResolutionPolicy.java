package com.ft.api.ucm.v1.model.aspect;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ConcreteFieldResolutionPolicy implements FieldResolutionPolicy {
	
	@Override
	public boolean hasField(Field field, Object object) {
		return containsField(field, object);
	}

	private boolean containsField(Field field, Object object) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(object);
		return beanWrapper.getPropertyTypeDescriptor(field.toString()) != null;
	}

}
