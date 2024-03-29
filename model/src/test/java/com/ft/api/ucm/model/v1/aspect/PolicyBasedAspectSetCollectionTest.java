package com.ft.api.ucm.model.v1.aspect;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ft.api.ucm.model.v1.AspectSetAware;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PolicyBasedAspectSetCollectionTest {

  @Mock private Set<AspectSet> mockAspectSets;
  @Mock private AspectSetSelectionPolicy mockAspectSetSelectionPolicy;
  @Mock private AspectSet mockAspectSet;
  @Mock private AspectSetAware mockAspectSetAware;

  private PolicyBasedAspectSetCollection instance;

  @BeforeEach
  public void setup() {
    instance = new PolicyBasedAspectSetCollection(mockAspectSets, mockAspectSetSelectionPolicy);
  }

  @Test
  public void constructObjectWithNullAspectSetsRaisesException() {
    assertThat(
        () -> new PolicyBasedAspectSetCollection(null, mockAspectSetSelectionPolicy),
        throwsException(IllegalArgumentException.class));
  }

  @Test
  public void constructObjectWithNullAspectSetSelectionPolicyRaisesException() {
    assertThat(
        () -> new PolicyBasedAspectSetCollection(mockAspectSets, null),
        throwsException(IllegalArgumentException.class));
  }

  @Test
  public void applyToSelectsAspectSetAndDelegates() {
    // Giving
    when(mockAspectSetSelectionPolicy.match(eq(mockAspectSets), eq(mockAspectSetAware.getClass())))
        .thenReturn(mockAspectSet);

    // When
    instance.applyTo(mockAspectSetAware);

    // Then
    verify(mockAspectSet).applyTo(mockAspectSetAware);
  }
}
