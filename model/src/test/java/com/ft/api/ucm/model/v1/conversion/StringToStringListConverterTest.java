package com.ft.api.ucm.model.v1.conversion;

import java.util.Arrays;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringToStringListConverterTest {

  private StringToStringListConverter converter;

  @Before
  public void setup() {
    converter = new StringToStringListConverter();
  }

  @Test
  public void convert() {
    String source = "[a,b,c]";
    List<String> expected = Arrays.asList("a", "b", "c");
    List<String> actual = converter.convert(source);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void convertEvenIfBlankCharacters() {
    String source = "[a,   b,  c ]";
    List<String> expected = Arrays.asList("a", "b", "c");
    List<String> actual = converter.convert(source);
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void unconvert() {
    List<String> source = Arrays.asList("a", "b", "c");
    String expected = "[a,b,c]";
    String actual = converter.unconvert(source);
    Assert.assertEquals(expected, actual);
  }
}
