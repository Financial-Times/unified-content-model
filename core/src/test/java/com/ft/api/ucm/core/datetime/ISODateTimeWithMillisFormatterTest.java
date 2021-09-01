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

public class ISODateTimeWithMillisFormatterTest {

  private static final DateTime DATE_TIME = new DateTime();

  private ISODateTimeWithMillisFormatter instance;

  @BeforeEach
  public void setUp() throws Exception {
    instance = new ISODateTimeWithMillisFormatter();
  }

  @Test
  public void formatDateTime() {
    assertThat(instance.format(DATE_TIME), equalTo(toIsoFormatWithUTCTimeZone(DATE_TIME)));
  }

  @Test
  public void nullDateInputThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> instance.format(null));
  }

  @Test
  public void whenAnIsoFormatStringIsProvidedADateIsReturned() {
    String text = "2011-07-14T23:58:04.123Z";
    ReadableDateTime dateTime = instance.parseDateTime(text);
    assertThat(dateTime, is(notNullValue()));
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
    String text = "2011-07-14T23:58:04.123Z";
    ReadableDateTime dateTime = new DateTime(2011, 7, 14, 23, 58, 4, 123, DateTimeZone.UTC);
    String formatted = instance.format(dateTime);
    assertThat(formatted, equalTo(text));
  }

  private String toIsoFormatWithUTCTimeZone(DateTime dateTime) {
    return dateTime.withZone(DateTimeZone.UTC).toString(ISODateTimeFormat.dateTime());
  }
}
