package com.ft.api.ucm.core.datetime;

import static org.hamcrest.MatcherAssert.assertThat;

import org.joda.time.format.ISODateTimeFormat;
import org.junit.jupiter.api.Test;

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
    assertThat("Clock wasn't static! Time delta was [" + (stop - start) + "]", stop == start);
  }

  @Test
  public void theClockTimeWasLater() {
    assertThat(String.format("Clock should be after %d", EARLIER), clock.isAfter(EARLIER));
  }

  @Test
  public void theClockTimeWasEarlier() {
    assertThat(String.format("Clock should be before %d", LATER), clock.isBefore(LATER));
  }

  @Test
  public void clockWrittenAsIsoFormattedString() {
    ISODateTimeFormat.dateTime().parseDateTime(clock.toString());
  }
}
