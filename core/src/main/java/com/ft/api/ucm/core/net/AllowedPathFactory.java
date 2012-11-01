package com.ft.api.ucm.core.net;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.core.Constants;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class AllowedPathFactory implements PathFactory {
	
	private static final class AllowedPathFunction implements Function<Object, String> {
		@Override
		public String apply(Object input) {
			return ObjectUtils.toString(input);
		}
	}

	private Set<String> allowedPaths;
	
	public AllowedPathFactory() {
		allowedPaths = Sets.newHashSet(Iterables.transform(new Constants(Paths.class).getValues(null), new AllowedPathFunction()));
	}
	
	@Override
	public Path createPath(String uri, Map<String, Object> vars) {
		assertUri(uri);
		return new Path.Builder(uri).withVars(vars).build();
	}

	@Override
	public Path createPath(String uri) {
		assertUri(uri);
		return new Path.Builder(uri).build();
	}
	
	private void assertUri(String uri) {
		if(!allowedPaths.contains(uri)){
			throw new IllegalArgumentException("Invalid uri '" + uri + "'");
		}
	}
	

}
