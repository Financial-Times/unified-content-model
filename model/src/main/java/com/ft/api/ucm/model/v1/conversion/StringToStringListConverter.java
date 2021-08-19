package com.ft.api.ucm.model.v1.conversion;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class StringToStringListConverter implements Converter<String, List<String>> {

  private static final String SEPARATOR = ",";
  private static final String START_LIST = "[";
  private static final String END_LIST = "]";

  @Override
  public List<String> convert(String source) {
    String modified = source;
    modified = StringUtils.remove(modified, START_LIST);
    modified = StringUtils.remove(modified, END_LIST);
    modified = modified.replaceAll("\\s", "");
    return Arrays.asList(modified.split(SEPARATOR));
  }

  public String unconvert(List<String> elements) {
    return START_LIST
        + StringUtils.join(elements.toArray(new String[elements.size()]), SEPARATOR)
        + END_LIST;
  }
}
