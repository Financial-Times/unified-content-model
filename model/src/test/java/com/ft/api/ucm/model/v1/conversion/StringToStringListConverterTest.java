package com.ft.api.ucm.model.v1.conversion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringToStringListConverterTest {

  private StringToStringListConverter converter;

  @BeforeEach
  public void setup() {
    converter = new StringToStringListConverter();
  }

  @Test
  public void convert() {
    String source = "[a,b,c]";
    List<String> expected = Arrays.asList("a", "b", "c");
    List<String> actual = converter.convert(source);
    assertThat(expected, equalTo(actual));
  }

  @Test
  public void convertEvenIfBlankCharacters() {
    String source = "[a,   b,  c ]";
    List<String> expected = Arrays.asList("a", "b", "c");
    List<String> actual = converter.convert(source);
    assertThat(expected, equalTo(actual));
  }

  @Test
  public void unconvert() {
    List<String> source = Arrays.asList("a", "b", "c");
    String expected = "[a,b,c]";
    String actual = converter.unconvert(source);
    assertThat(expected, equalTo(actual));
  }
}
