package com.ft.api.ucm.core.datetime;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;

public abstract class BaseJsonDateTimeSerializer extends JsonSerializer<DateTime> {

  protected DateTimeFormatter dateTimeFormatter;

  @Override
  public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    if (value != null) {
      String formattedDate = dateTimeFormatter.format(value);
      jgen.writeString(formattedDate);
    }
  }
}
