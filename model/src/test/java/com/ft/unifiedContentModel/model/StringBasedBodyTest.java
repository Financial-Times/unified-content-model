package com.ft.unifiedContentModel.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.ft.unifiedContentModel.model.Body;
import com.ft.unifiedContentModel.model.StringBasedBody;

public class StringBasedBodyTest {
	
	private static final String TEXT = "The quick brown fox jumps over the lazy dog";
	
	private StringBasedBody instance;
	
	@Before
	public void setUp() {
		instance = new StringBasedBody(TEXT);
	}

	@Test
	public void bodyTextEmptyIfConstructorArgIsNull() {
		instance = new StringBasedBody(null);
		assertThat(instance.toString(), equalTo(null));
	}

	@Test
	public void equalIfTheyAreTheSame() {
		Body another = instance;
		assertThat(instance, equalTo(another));
		assertThat(instance.hashCode(), is(another.hashCode()));
	}
	
	@Test
	public void notEqualIfOneIsNull() {
		Body another = null;
		assertThat(instance, not(equalTo(another)));
	}
	
	@Test
	public void twoDifferentInstancesAreNotEqual() {
		Body another = new StringBasedBody("I AM NOT A FOX OR A DOG");
		assertThat(instance, not(equalTo(another)));
	}

}
