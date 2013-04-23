package com.ft.api.ucm.model.v1;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.google.common.base.Objects;

@JsonPropertyOrder({"runtimeMilliseconds"})
public class AudioVisualImpl implements AudioVisual{
	
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
		return Objects.toStringHelper(this)
					.add("runtimeMilliseconds", getRuntimeMilliseconds())
					.toString();
	}
}
