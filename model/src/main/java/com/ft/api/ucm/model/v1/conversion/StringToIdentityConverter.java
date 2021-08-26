package com.ft.api.ucm.model.v1.conversion;

import com.ft.api.ucm.model.v1.Identity;
import org.springframework.core.convert.converter.Converter;

public class StringToIdentityConverter implements Converter<String, Identity> {

  @Override
  public Identity convert(String source) {
    return Identity.fromValue(source);
  }
}
