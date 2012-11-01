package com.ft.api.ucm.model.v1;

import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;


public class ProvenanceImpl implements Provenance {
	
	private String originatingParty;
	
	public ProvenanceImpl() {}
	
	public ProvenanceImpl(String originatingParty) {
		this.originatingParty = StringUtils.isNotBlank(originatingParty) ? originatingParty : null;
	}

	@Override
	public String getOriginatingParty(){
		return originatingParty;
	}
	
	public void setOriginatingParty(String originatingParty){
		this.originatingParty = originatingParty;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("originatingParty", originatingParty).toString();
	}
}
