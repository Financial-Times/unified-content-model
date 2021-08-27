package com.ft.api.ucm.core.datetime;

import static org.hamcrest.MatcherAssert.assertThat;

import org.joda.time.format.ISODateTimeFormat;
import org.junit.jupiter.api.Test;

public class SystemClockTest {

  private SystemClock clock = new SystemClock();

  @Test
  public void clockTimeRunning() throws InterruptedException {
    long start = clock.getTime();
    Thread.sleep(100);
    long stop = clock.getTime();
    assertThat("Clock stopped! Time delta was [" + (stop - start) + "]", stop > start);
  }

  @Test
  public void clockWrittenAsIsoFormattedString() {
    ISODateTimeFormat.dateTime().parseDateTime(clock.toString());
  }

  @Test
  public void theClockTimeWasLater() {
    long then = Long.MIN_VALUE;
    assertThat("Clock should be after min long", clock.isAfter(then));
  }

  @Test
  public void theClockTimeWasEarlier() {
    long theFuture = Long.MAX_VALUE;
    assertThat("Clock should be before max long", clock.isBefore(theFuture));
  }
}
