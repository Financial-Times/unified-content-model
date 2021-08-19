package com.ft.api.ucm.model.v1.aspect;

import com.ft.api.ucm.model.v1.AspectSetAware;

public interface AspectSetCollection {

  void applyTo(AspectSetAware aspectSetAware);
}
