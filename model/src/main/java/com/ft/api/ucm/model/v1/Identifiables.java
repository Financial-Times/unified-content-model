package com.ft.api.ucm.model.v1;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * This class contains static utility methods that operate on or return objects of type {@code
 * Identifiable}.
 */
public final class Identifiables {

  public static final Function<Identifiable, String> GET =
      new Function<Identifiable, String>() {
        public String apply(Identifiable identifiable) {
          return identifiable.getId();
        }
      };

  private Identifiables() {}

  public static Iterable<String> of(Iterable<? extends Identifiable> items) {
    return Iterables.transform(items, GET);
  }
}
