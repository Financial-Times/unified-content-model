package com.ft.api.ucm.core.datetime;

import static org.junit.Assert.assertTrue;

import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

public class SystemClockTest {

  private SystemClock clock = new SystemClock();

  @Test
  public void clockTimeRunning() throws InterruptedException {
    long start = clock.getTime();
    Thread.sleep(100);
    long stop = clock.getTime();
    assertTrue("Clock stopped! Time delta was [" + (stop - start) + "]", stop > start);
  }

  @Test
  public void clockWrittenAsIsoFormattedString() {
    ISODateTimeFormat.dateTime().parseDateTime(clock.toString());
  }

  @Test
  public void theClockTimeWasLater() {
    long then = Long.MIN_VALUE;
    assertTrue(clock.isAfter(then));
  }

  @Test
  public void theClockTimeWasEarlier() {
    long theFuture = Long.MAX_VALUE;
    assertTrue(clock.isBefore(theFuture));
  }
}
