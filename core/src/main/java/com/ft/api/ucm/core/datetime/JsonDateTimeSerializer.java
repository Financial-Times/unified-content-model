package com.ft.api.ucm.core.datetime;

import static org.springframework.util.Assert.notNull;

import org.springframework.stereotype.Component;

@Component
public class JsonDateTimeSerializer extends BaseJsonDateTimeSerializer {

  public JsonDateTimeSerializer() {
    this(new ISODateTimeFormatter());
  }

  JsonDateTimeSerializer(DateTimeFormatter dateTimeFormatter) {
    notNull(dateTimeFormatter);
    super.dateTimeFormatter = dateTimeFormatter;
  }
}
