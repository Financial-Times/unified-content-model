package com.ft.api.ucm.model.v1.aspect;

import static java.lang.Boolean.TRUE;
import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ImmutableFieldTest {

  private static final String NAME = "name";
  private static final String ANOTHER_NAME = "zzz";

  @Mock private FieldResolutionPolicy mockFieldResolutionPolicy;

  private Field instance;

  @BeforeEach
  public void setup() {
    instance = ImmutableField.valueOf(NAME, mockFieldResolutionPolicy);
  }

  @Test
  public void constructObjectWithNullNameRaisesException() {
    assertThat(
        () -> ImmutableField.valueOf(null, mockFieldResolutionPolicy),
        throwsException(IllegalArgumentException.class));
  }

  @Test
  public void constructObjectWithNullResolutionPolicyRaisesException() {
    assertThat(
        () -> ImmutableField.valueOf(NAME, null), throwsException(IllegalArgumentException.class));
  }

  @Test
  public void twoFieldsAreEqualIfTheyAreTheSame() {
    Field another = instance;
    assertThat(another, equalTo(instance));
    assertThat(another.hashCode(), is(instance.hashCode()));
  }

  @Test
  public void twoFieldsAreNotEqualIfOneIsNull() {
    Field another = null;
    assertThat(another, not(equalTo(instance)));
  }

  @Test
  public void twoDifferentFieldsAreNotEqual() {
    Field another = ImmutableField.valueOf(ANOTHER_NAME, mockFieldResolutionPolicy);
    assertThat(another, not(equalTo(instance)));
  }

  @Test
  public void aspectSetsAreComparableByName() {
    Field another = ImmutableField.valueOf(ANOTHER_NAME, mockFieldResolutionPolicy);
    assertThat(instance, lessThan(another));
  }

  @Test
  public void objectIsAssignableFrom() {
    Object test = new Object();
    when(mockFieldResolutionPolicy.hasField(instance, test)).thenReturn(TRUE);
    assertThat(instance.assignableFrom(test), is(TRUE));
  }

  @Test
  public void toStringReturnsName() {
    assertThat(instance, hasToString(equalTo(NAME)));
  }
}
