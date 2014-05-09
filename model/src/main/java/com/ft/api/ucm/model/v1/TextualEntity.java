package com.ft.api.ucm.model.v1;

import com.ft.api.ucm.model.v1.aspect.AspectEnum;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class TextualEntity extends ContentEntity {

    private TextualBody textualBody;

    public TextualEntity() {
    }

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
            case TEXTUALBODY: setTextualBody(null);
            default: super.suppressAspect(aspect);
        }
    }
}
