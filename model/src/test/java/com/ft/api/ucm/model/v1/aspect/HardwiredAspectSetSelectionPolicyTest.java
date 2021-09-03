package com.ft.api.ucm.model.v1.aspect;

import static net.obvj.junit.utils.matchers.AdvancedMatchers.throwsException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyZeroInteractions;

import com.ft.api.ucm.model.v1.AspectSetAware;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HardwiredAspectSetSelectionPolicyTest {

  @Mock private Set<AspectSet> mockAspectSets;
  @Mock private AspectSet mockAspectSet;
  @Mock private AspectSetAware mockAspectSetAware;

  private HardwiredAspectSetSelectionPolicy instance;

  @Test
  public void ifSuppliedAspectSetIsNullExceptionThrown() {
    assertThat(
        () -> new HardwiredAspectSetSelectionPolicy(null),
        throwsException(IllegalArgumentException.class));
  }

  @Test
  public void sameAspectSetReturnedAlways() {
    instance = new HardwiredAspectSetSelectionPolicy(mockAspectSet);
    assertEquals(mockAspectSet, instance.match(mockAspectSets, mockAspectSetAware.getClass()));
    verifyZeroInteractions(mockAspectSets);
  }
}
