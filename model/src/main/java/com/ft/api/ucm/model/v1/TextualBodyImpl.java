package com.ft.api.ucm.model.v1;

import com.google.common.base.Objects;

public class TextualBodyImpl implements TextualBody {

  private boolean imageLed;

  public TextualBodyImpl() {}

  public TextualBodyImpl(boolean imageLed) {
    this.imageLed = imageLed;
  }

  public void setImageLed(boolean imageLed) {
    this.imageLed = imageLed;
  }

  @Override
  public boolean isImageLed() {
    return imageLed;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this).add("imageLed", imageLed).toString();
  }
}
