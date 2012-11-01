package com.ft.api.ucm.v1.model;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * <p>This class contains static utility methods that operate on or return objects
 * of type {@code Identifiable}.</p>
 */
public final class Identifiables {

	public static final Function<Identifiable, String> GET = new Function<Identifiable, String>() {
		public String apply(Identifiable identifiable) {
			return identifiable.getId();
		}
	};
	
	private Identifiables() {}

	public static Iterable<String> of(Iterable<? extends Identifiable> items) {
		return Iterables.transform(items, GET);
	}

}
