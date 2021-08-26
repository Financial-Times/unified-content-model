package com.ft.api.ucm.core.datetime;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.ReadableDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JsonDateTimeSerializerTest {

  private static final String DATE_STRING = "2011-03-26T12:00:00.000Z";

  @Mock private DateTimeFormatter mockDateTimeFormatter;
  @Mock private ReadableDateTime mockDateTime;
  @Mock private JsonGenerator jsonGenerator;
  @Mock private SerializerProvider serializerProvider;

  private JsonDateTimeSerializer jsonDateTimeSerializer;

  @Before
  public void setup() {
    jsonDateTimeSerializer = new JsonDateTimeSerializer(mockDateTimeFormatter);
  }

  @Test
  public void dateTimeIsWrittenAsString() {
    try {
      DateTime dateTime = new DateTime();
      jsonDateTimeSerializer.serialize(dateTime, jsonGenerator, serializerProvider);
      verify(mockDateTimeFormatter).format(dateTime);
      verify(jsonGenerator).writeString(anyString());

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
