package com.ft.unifiedContentModel.model.metadata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.ft.unifiedContentModel.model.XSDs;
import com.google.common.base.Objects;

@XmlType(name="tag", namespace=XSDs.METADATA_NAMESPACE)
public class TagImpl implements Tag {
	
	private Term term;
	
	public TagImpl() {
	}
	
	public TagImpl(Term term){
		this.term = term;
	}

	@Override
	@XmlElement(name="term", type=TermImpl.class, namespace=XSDs.METADATA_NAMESPACE)
	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("term", term).toString();
	}
	
	@Override
	public boolean equals(Object that) {
		if(that == null){
			return false;
		}
		if(that == this){
			return true;
		}
		if(that instanceof TagImpl) {
			TagImpl thatTag = (TagImpl)that;
			return Objects.equal(this.getTerm(), thatTag.getTerm());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.getTerm());
	}

}
