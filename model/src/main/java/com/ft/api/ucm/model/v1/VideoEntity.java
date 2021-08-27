package com.ft.api.ucm.model.v1;

import static org.springframework.util.Assert.notNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ft.api.ucm.model.v1.aspect.AspectEnum;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
  "aspectSet",
  "aspects",
  "modelVersion",
  "id",
  "apiUrl",
  "title",
  "lifecycle",
  "nature",
  "location",
  "master",
  "editorial",
  "audioVisual"
})
public class VideoEntity extends ContentEntity implements Video {

  private AudioVisual audioVisual;

  public VideoEntity() {}

  public VideoEntity(String id, String apiUrl) {
    super(id, apiUrl);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VideoEntity) {
      VideoEntity a = (VideoEntity) o;
      return Objects.equal(this.getId(), a.getId());
    }
    return false;
  }

  @Override
  public AudioVisual getAudioVisual() {
    return audioVisual;
  }

  public void setAudioVisual(AudioVisual audioVisual) {
    this.audioVisual = audioVisual;
  }

  @Override
  protected ToStringHelper toStringHelper() {
    ToStringHelper toStringHelper = super.toStringHelper();
    return toStringHelper
        .add("aspectSet", getAspectSet())
        .add("aspects", getAspects())
        .add("location", getLocation())
        .add("master", getMaster())
        .add("nature", getNature())
        .add("editorial", getEditorial())
        .add("audioVisual", getAudioVisual());
  }

  @Override
  public void suppressAspect(String aspect) {
    super.suppressAspect(aspect);
    AspectEnum aspectValue = AspectEnum.getByValue(aspect);
    notNull(aspectValue, "aspect " + aspect + " is not a valid AspectEnum value");
    if (AspectEnum.AUDIOVISUAL.equals(aspectValue)) {
      setAudioVisual(null);
    }
  }
}
