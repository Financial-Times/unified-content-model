package com.ft.unifiedContentModel.model.conversion;

import org.springframework.core.convert.converter.Converter;

import com.ft.unifiedContentModel.model.Identity;

public class StringToIdentityConverter implements Converter<String, Identity> {

	@Override
	public Identity convert(String source) {
		return Identity.fromValue(source);
	}

}
