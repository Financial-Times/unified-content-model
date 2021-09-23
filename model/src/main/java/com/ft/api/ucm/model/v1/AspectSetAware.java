package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public interface AspectSetAware {

  @JsonIgnore
  void setAspectSet(String aspectSetName);

  void setAspects(List<String> aspectNames);
}
