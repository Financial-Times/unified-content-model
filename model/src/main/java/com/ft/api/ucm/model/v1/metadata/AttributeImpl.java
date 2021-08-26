package com.ft.api.ucm.model.v1.metadata;

import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.springframework.util.Assert;

@JsonPropertyOrder({"key", "value"})
public class AttributeImpl implements Attribute, Comparable<AttributeImpl> {

  private String key;
  private String value;

  public AttributeImpl() {}

  public AttributeImpl(String key, String value) {
    Assert.notNull(key);
    Assert.notNull(value);
    this.key = key;
    this.value = value;
  }

  @Override
  public String getKey() {
    return key;
  }

  @Override
  public String getValue() {
    return value;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object that) {
    if (that == null) {
      return false;
    }
    if (that == this) {
      return true;
    }
    if (that instanceof AttributeImpl) {
      AttributeImpl thatAttribute = (AttributeImpl) that;
      return Objects.equal(key, thatAttribute.getKey())
          && Objects.equal(value, thatAttribute.getValue());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(key, value);
  }

  @Override
  public int compareTo(AttributeImpl that) {
    return key.compareTo(that.getKey());
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("key", key).add("value", value).toString();
  }
}
