package com.ft.api.ucm.core.datetime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableDateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ISODateTimeFormatterTest {

  private static final DateTime DATE_TIME = new DateTime();

  private ISODateTimeFormatter instance;

  @BeforeEach
  public void setUp() {
    instance = new ISODateTimeFormatter();
  }

  @Test
  public void formatDateTime() {
    assertThat(toIsoFormatWithUTCTimeZone(DATE_TIME), equalTo(instance.format(DATE_TIME)));
  }

  @Test
  public void nullDateInputThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> instance.format(null));
  }

  @Test
  public void whenAnIsoFormatStringIsProvidedADateIsReturned() {
    String text = "2011-07-14T23:58:04Z";
    ReadableDateTime dateTime = instance.parseDateTime(text);
    assertThat(dateTime, notNullValue());
  }

  @Test
  public void whenANonIsoFormatStringIsProvidedAnIllegalArgumentExceptionIsThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          String text = "2011-07-14";
          instance.parseDateTime(text);
        });
  }

  @Test
  public void whenAnEmptyStringIsProvidedAnIllegalArgumentExceptionIsThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          String text = "";
          instance.parseDateTime(text);
        });
  }

  @Test
  public void whenNullIsProvidedAnIllegalArgumentExceptionIsThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          String text = null;
          instance.parseDateTime(text);
        });
  }

  @Test
  public void whenADateTimeIsFormattedAnIsoFormattedDateIsReturned() {
    String text = "2011-07-14T23:58:04Z";
    ReadableDateTime dateTime = new DateTime(2011, 7, 14, 23, 58, 4, 0, DateTimeZone.UTC);
    String formatted = instance.format(dateTime);
    assertThat(text, equalTo(formatted));
  }

  private String toIsoFormatWithUTCTimeZone(DateTime dateTime) {
    return dateTime.withZone(DateTimeZone.UTC).toString(ISODateTimeFormat.dateTimeNoMillis());
  }
}
