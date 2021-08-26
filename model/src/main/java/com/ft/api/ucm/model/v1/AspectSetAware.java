package com.ft.api.ucm.model.v1;

import java.util.List;

public interface AspectSetAware {

  void setAspectSet(String aspectSetName);

  void setAspects(List<String> aspectNames);
}
