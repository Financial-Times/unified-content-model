package com.ft.api.ucm.v1.model.aspect;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.collect.Sets;

public class NamedNodeTest {
	
	private static final String NAME = "NAME";
	private static final String A = "A";
	private static final String B = "B";
	private static final String C = "C";
	
	private NamedNode<String> instance;
	
	@Test(expected=IllegalArgumentException.class)
	public void constructWithNullNameRaisesException() {
		new NamedNode<String>(null, Sets.<String>newHashSet());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructWithNullChildrenRaisesException() {
		new NamedNode<String>(NAME, null);
	}
	
	@Test
	public void constructorSortsChildSet() {
		instance = new NamedNode<String>(NAME, Sets.newHashSet(C, B, A));
		assertEquals(Sets.newTreeSet(Sets.newHashSet(C, B, A)), instance.getChildren());
	}
	
	@Test
	public void toStringReturnsName() {
		instance = new NamedNode<String>(NAME, Sets.newHashSet(A, B, C));
		assertThat(instance, hasToString(equalTo(NAME)));
	}
	
	@Test
	public void equal(){
		instance = new NamedNode<String>(NAME, Sets.newHashSet(A, B, C));
		NamedNode<String> anotherInstance = new NamedNode<String>(NAME, Sets.newHashSet(A, B, C));
		assertEquals(instance, instance);
		assertEquals(anotherInstance, instance);
		assertTrue(instance.hashCode() == anotherInstance.hashCode());
	}
	
	@Test
	public void notEqual(){
		instance = new NamedNode<String>(NAME, Sets.newHashSet(A, B, C));
		NamedNode<String> anotherInstance = new NamedNode<String>(NAME + "2", Sets.newHashSet(A, B, C));
		assertFalse(instance.equals(null));
		assertFalse(instance.equals(anotherInstance));
		assertFalse(instance.hashCode() == anotherInstance.hashCode());
	}
}
