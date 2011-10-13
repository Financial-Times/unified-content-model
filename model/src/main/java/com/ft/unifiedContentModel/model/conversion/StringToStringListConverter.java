package com.ft.unifiedContentModel.model.conversion;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class StringToStringListConverter implements Converter<String, List<String>> {

	private static final String SEPARATOR = ",";
	private static final String START_LIST = "[";
	private static final String END_LIST = "]";
	
	@Override
	public List<String> convert(String source) {
		source = StringUtils.remove(source, START_LIST);
		source = StringUtils.remove(source, END_LIST);
		source = source.replaceAll("\\s", "");
		return Arrays.asList(source.split(SEPARATOR));
	}
	
	public String unconvert(List<String> elements) {
		return START_LIST+StringUtils.join(elements.toArray(new String[elements.size()]), SEPARATOR)+END_LIST;
	}

	

}
