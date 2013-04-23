package com.ft.api.ucm.model.v1;

import static org.springframework.util.Assert.notNull;

import org.codehaus.jackson.annotate.JsonPropertyOrder;


import com.ft.api.ucm.model.v1.aspect.AspectEnum;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;


@JsonPropertyOrder({"aspectSet", "aspects", "modelVersion", "id",  "title", "lifecycle", "nature", "location", "master","editorial","audioVisual"})
public class PodcastEntity extends ContentEntity implements Podcast {
	
	private AudioVisual audioVisual;
	
	public PodcastEntity() {}
	
	public PodcastEntity(String id,String apiUrl){
		super(id, apiUrl);
	}
	
	@Override
	public AudioVisual getAudioVisual() {
		return audioVisual;
	}
	
	public void setAudioVisual(AudioVisual audioVisual) {
		this.audioVisual = audioVisual;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this){
			return true;
		}
		if(o instanceof PodcastEntity) {
			PodcastEntity a = (PodcastEntity)o;
			return Objects.equal(this.getId(), a.getId());
		}
		return false;
	}
	
	
	@Override
	protected ToStringHelper toStringHelper() {
		ToStringHelper toStringHelper = super.toStringHelper();
		return toStringHelper
					.add("aspectSet", getAspectSet())
					.add("aspects", getAspects())
					.add("location", getLocation())
					.add("master", getMaster())
					.add("editorial",getEditorial())
					.add("audioVisual",getAudioVisual());
	}
	
	@Override
	public void suppressAspect(String aspect) {
		super.suppressAspect(aspect);
		AspectEnum aspectValue = AspectEnum.getByValue(aspect); 
		notNull(aspectValue, "aspect " + aspect + " is not a valid AspectEnum value");
		if(AspectEnum.AUDIOVISUAL.equals(aspectValue)){
			setAudioVisual(null);
		}
	}


}
