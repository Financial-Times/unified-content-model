package com.ft.api.ucm.model.v1.aspect;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ft.api.ucm.model.v1.AspectSetAware;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ImmutableAspectSetTest {

  private static final String NAME = AspectEnum.LIFECYCLE.getName();
  private static final String ANOTHER_NAME = AspectEnum.TITLE.getName();

  @Mock private AssignableVoter mockAssignableVoter;
  @Mock private AspectSetAware mockAspectSetAware;

  private Aspect aspect;
  private Aspect anotherAspect;

  private Set<Aspect> aspects;
  private ImmutableAspectSet instance;

  @BeforeEach
  public void setup() {
    aspect = ImmutableAspect.valueOf(NAME, Sets.<Field>newHashSet(), mockAssignableVoter);
    anotherAspect =
        ImmutableAspect.valueOf(ANOTHER_NAME, Sets.<Field>newHashSet(), mockAssignableVoter);
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
    assertThat(anotherAspectSet, equalTo(instance));
    assertThat(anotherAspectSet.hashCode(), is(instance.hashCode()));
  }

  @Test
  public void twoAspectSetsAreNotEqualIfOneIsNull() {
    instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
    AspectSet anotherAspectSet = null;
    assertThat(anotherAspectSet, not(equalTo(instance)));
  }

  @Test
  public void twoDifferentAspectSetsAreNotEqual() {
    instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
    AspectSet anotherAspectSet =
        ImmutableAspectSet.valueOf(ANOTHER_NAME, aspects, mockAssignableVoter);
    assertThat(anotherAspectSet, not(equalTo(instance)));
  }

  @Test
  public void aspectSetsAreComparableByName() {
    instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
    AspectSet anotherAspectSet =
        ImmutableAspectSet.valueOf(ANOTHER_NAME, aspects, mockAssignableVoter);
    assertThat(instance, lessThan(anotherAspectSet));
  }

  @Test
  public void objectIsAssignableFrom() {
    Object test = new Object();
    when(mockAssignableVoter.vote(aspects, test)).thenReturn(TRUE);
    instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
    assertThat(instance.assignableFrom(test), is(TRUE));
  }

  @Test
  public void toStringReturnsName() {
    instance = ImmutableAspectSet.valueOf(NAME, aspects, mockAssignableVoter);
    assertThat(instance, hasToString(equalTo(NAME)));
  }
}
