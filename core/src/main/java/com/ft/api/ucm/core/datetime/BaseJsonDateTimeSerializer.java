package com.ft.api.ucm.core.datetime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.joda.time.DateTime;

public abstract class BaseJsonDateTimeSerializer extends JsonSerializer<DateTime> {
  protected DateTimeFormatter dateTimeFormatter;

  @Override
  public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {
    if (value != null) {
      String formattedDate = dateTimeFormatter.format(value);
      jgen.writeString(formattedDate);
    }
  }
}
