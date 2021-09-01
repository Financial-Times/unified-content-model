package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"source", "sourceReference"})
public class VideoFields {
  private String source;
  private String sourceReference;

  public VideoFields() {}

  public VideoFields(String source, String sourceReference) {
    this.source = source;
    this.sourceReference = sourceReference;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getSourceReference() {
    return sourceReference;
  }

  public void setSourceReference(String sourceReference) {
    this.sourceReference = sourceReference;
  }
}
