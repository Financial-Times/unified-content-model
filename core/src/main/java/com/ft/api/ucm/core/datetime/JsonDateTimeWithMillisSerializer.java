package com.ft.api.ucm.core.datetime;

import static org.springframework.util.Assert.notNull;

import org.springframework.stereotype.Component;

@Component
public class JsonDateTimeWithMillisSerializer extends BaseJsonDateTimeSerializer {

  public JsonDateTimeWithMillisSerializer() {
    this(new ISODateTimeWithMillisFormatter());
  }

  JsonDateTimeWithMillisSerializer(DateTimeFormatter dateTimeFormatter) {
    notNull(dateTimeFormatter);
    super.dateTimeFormatter = dateTimeFormatter;
  }
}
