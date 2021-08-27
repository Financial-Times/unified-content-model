package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"runtimeMilliseconds"})
public class AudioVisualImpl implements AudioVisual {

  private Long runtimeMilliseconds;

  public AudioVisualImpl() {}

  public AudioVisualImpl(Long runtimeMilliseconds) {
    this.runtimeMilliseconds = runtimeMilliseconds;
  }

  @Override
  public Long getRuntimeMilliseconds() {
    return runtimeMilliseconds;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("runtimeMilliseconds", getRuntimeMilliseconds())
        .toString();
  }
}
