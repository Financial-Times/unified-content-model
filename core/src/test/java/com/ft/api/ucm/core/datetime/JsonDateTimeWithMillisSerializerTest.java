package com.ft.api.ucm.core.datetime;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.ReadableDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JsonDateTimeWithMillisSerializerTest {

  private static final String DATE_STRING = "2011-03-26T12:00:00.000Z";

  @Mock private DateTimeFormatter mockDateTimeFormatter;
  @Mock private ReadableDateTime mockDateTime;
  @Mock private JsonGenerator jsonGenerator;
  @Mock private SerializerProvider serializerProvider;

  private BaseJsonDateTimeSerializer jsonDateTimeSerializer;

  @BeforeEach
  public void setup() {
    jsonDateTimeSerializer = new JsonDateTimeWithMillisSerializer(mockDateTimeFormatter);
  }

  @Test
  public void dateTimeIsWrittenAsString() {
    try {
      DateTime dateTime = new DateTime();
      jsonDateTimeSerializer.serialize(dateTime, jsonGenerator, serializerProvider);
      verify(mockDateTimeFormatter).format(dateTime);
      verify(jsonGenerator).writeString((String) any());

    } catch (Exception e) {
      fail("Exception not expected");
    }
  }

  @Test
  public void nullDateTimeIsWrittenAsEmptyString() {
    try {
      DateTime dateTime = new DateTime();
      jsonDateTimeSerializer.serialize(null, jsonGenerator, serializerProvider);
      verify(mockDateTimeFormatter, never()).format(dateTime);
      verify(jsonGenerator, never()).writeString(anyString());

    } catch (Exception e) {
      fail("Exception not expected");
    }
  }
}
