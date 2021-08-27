package com.ft.api.ucm.model.v1.aspect;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConcreteFieldResolutionPolicyTest {

  private static final String NAME = "name";
  private static final String NON_EXISTENT = "foo";
  private static final Object TEST_OBJ =
      new Object() {
        @SuppressWarnings("unused")
        public String getName() {
          return NAME;
        }
      };

  @Mock private Field mockField;
  private ConcreteFieldResolutionPolicy instance;

  @BeforeEach
  public void setUp() throws Exception {
    instance = new ConcreteFieldResolutionPolicy();
  }

  @Test
  public void existingPropertyIsFound() {
    when(mockField.toString()).thenReturn(NAME);
    assertThat(TRUE, is(instance.hasField(mockField, TEST_OBJ)));
  }

  @Test
  public void nonExistantPropertyIsNotFound() {
    when(mockField.toString()).thenReturn(NON_EXISTENT);
    assertThat(FALSE, is(instance.hasField(mockField, TEST_OBJ)));
  }
}
