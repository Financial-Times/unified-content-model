package com.ft.api.ucm.model.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ft.api.ucm.model.v1.aspect.AspectEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextualEntity extends ContentEntity {

  private TextualBody textualBody;

  public TextualEntity() {}

  public TextualEntity(String id, String apiUrl) {
    super(id, apiUrl);
  }

  public TextualBody getTextualBody() {
    return textualBody;
  }

  public void setTextualBody(TextualBody textualBody) {
    this.textualBody = textualBody;
  }

  @Override
  public void suppressAspect(String aspect) {
    AspectEnum aspectValue = AspectEnum.getByValue(aspect);
    switch (aspectValue) {
      case TEXTUALBODY:
        setTextualBody(null);
      default:
        super.suppressAspect(aspect);
    }
  }
}
