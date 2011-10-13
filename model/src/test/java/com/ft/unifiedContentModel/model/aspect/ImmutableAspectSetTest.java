package com.ft.unifiedContentModel.model.aspect;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.model.AspectSetAware;
import com.ft.unifiedContentModel.model.aspect.Aspect;
import com.ft.unifiedContentModel.model.aspect.AspectSet;
import com.ft.unifiedContentModel.model.aspect.AssignableVoter;
import com.ft.unifiedContentModel.model.aspect.Field;
import com.ft.unifiedContentModel.model.aspect.ImmutableAspect;
import com.ft.unifiedContentModel.model.aspect.ImmutableAspectSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@RunWith(MockitoJUnitRunner.class)
public class ImmutableAspectSetTest {
	
	private final static String NAME = "name";
	private final static String ANOTHER_NAME = "zzz";
	
	@Mock private AssignableVoter mockAssignableVoter;
	@Mock private AspectSetAware mockAspectSetAware;
	
	private Aspect aspect;
	private Aspect anotherAspect;
	
	private Set<Aspect> aspects;
	private ImmutableAspectSet instance;
	
	@Before
	public void setup() {
		aspect = ImmutableAspect.valueOf(NAME, Sets.<Field>newHashSet(), mockAssignableVoter);
		anotherAspect = ImmutableAspect.valueOf(ANOTHER_NAME, Sets.<Field>newHashSet(), mockAssignableVoter);
		aspects = Sets.newHashSet(aspect, anotherAspect);
	}
	
	@Test
	public void stateIsWrittenToCollaborator() {
		instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
		instance.applyTo(mockAspectSetAware);
		verify(mockAspectSetAware).setAspects(eq(Lists.<String>newArrayList(NAME, ANOTHER_NAME)));
		verify(mockAspectSetAware).setAspectSet(NAME);
	}
	
	@Test
	public void stateIsWrittenToCollaboratorIfAspectsAreEmpty() {
		instance = ImmutableAspectSet.valueOf(NAME, Sets.<Aspect>newHashSet(), mockAssignableVoter);
		instance.applyTo(mockAspectSetAware);
		verify(mockAspectSetAware).setAspects(eq(Lists.<String>newArrayList()));
		verify(mockAspectSetAware).setAspectSet(NAME);
	}
	
	@Test
	public void twoAspectSetsAreEqualIfTheyAreTheSame() {
		instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
		AspectSet anotherAspectSet = instance;
		assertThat(instance, equalTo(anotherAspectSet));
		assertThat(instance.hashCode(), is(anotherAspectSet.hashCode()));
	}
	
	@Test
	public void twoAspectSetsAreNotEqualIfOneIsNull() {
		instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
		AspectSet anotherAspectSet = null;
		assertThat(instance, not(equalTo(anotherAspectSet)));
	}
	
	@Test
	public void twoDifferentAspectSetsAreNotEqual() {
		instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
		AspectSet anotherAspectSet = ImmutableAspectSet.valueOf(ANOTHER_NAME, aspects, mockAssignableVoter);
		assertThat(instance, not(equalTo(anotherAspectSet)));
	}
	
	@Test
	public void aspectSetsAreComparableByName() {
		instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
		AspectSet anotherAspectSet = ImmutableAspectSet.valueOf(ANOTHER_NAME, aspects, mockAssignableVoter);
		assertThat(instance, lessThan(anotherAspectSet));
	}
	
	@Test
	public void objectIsAssignableFrom() {
		Object test = new Object();
		when(mockAssignableVoter.vote(aspects, test)).thenReturn(Boolean.TRUE);
		instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
		assertThat(instance.assignableFrom(test), is(Boolean.TRUE));
	}

	@Test
	public void toStringReturnsName() {
		instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
		assertThat(instance, hasToString(equalTo(NAME)));
	}
	
}
