package com.ft.api.ucm.v1.model.conversion;

import org.springframework.core.convert.converter.Converter;

import com.ft.api.ucm.v1.model.Identity;

public class StringToIdentityConverter implements Converter<String, Identity> {

	@Override
	public Identity convert(String source) {
		return Identity.fromValue(source);
	}

}
