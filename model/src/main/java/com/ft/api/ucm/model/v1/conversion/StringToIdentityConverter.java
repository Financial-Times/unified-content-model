package com.ft.api.ucm.model.v1.conversion;

import org.springframework.core.convert.converter.Converter;

import com.ft.api.ucm.model.v1.Identity;

public class StringToIdentityConverter implements Converter<String, Identity> {

	@Override
	public Identity convert(String source) {
		return Identity.fromValue(source);
	}

}
