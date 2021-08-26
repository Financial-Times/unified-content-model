package com.ft.api.ucm.core.datetime;

import static org.junit.Assert.assertTrue;

import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

public class ControlledClockTest {

  private static final long TIME = 1320120983204L;
  private static final long LATER = 1320120983804L;
  private static final long EARLIER = 1320120981001L;

  private ControlledClock clock = new ControlledClock(TIME);

  @Test
  public void clockTimeStatic() throws InterruptedException {
    long start = clock.getTime();
    Thread.sleep(100);
    long stop = clock.getTime();
    assertTrue("Clock wasn't static! Time delta was [" + (stop - start) + "]", stop == start);
  }

  @Test
  public void theClockTimeWasLater() {
    assertTrue(clock.isAfter(EARLIER));
  }

  @Test
  public void theClockTimeWasEarlier() {
    assertTrue(clock.isBefore(LATER));
  }

  @Test
  public void clockWrittenAsIsoFormattedString() {
    ISODateTimeFormat.dateTime().parseDateTime(clock.toString());
  }
}
