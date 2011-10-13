package com.ft.unifiedContentModel.model.aspect;

import static org.springframework.util.Assert.notNull;

import java.util.Set;

public final class CompositeField implements Field {

	private AssignableVoter assignableVoter;
	private NamedNode<Field> namedNode;
	
	public CompositeField(String name, Set<Field> fields, AssignableVoter assignableVoter) {
		notNull(assignableVoter);
		namedNode = new NamedNode<Field>(name, fields);
		this.assignableVoter = assignableVoter;
	}

	@Override
	public boolean assignableFrom(Object object) {
		return assignableVoter.vote(namedNode.getChildren(), object);
	}
	
	@Override
	public boolean equals(Object that) {
		if (!(that instanceof CompositeField)) {
			return false;
		}
		CompositeField thatField = (CompositeField) that;
		return namedNode.equals(thatField.namedNode);
	}
	
	@Override
	public int hashCode() {
		return namedNode.hashCode();
	}
	
	@Override
	public String toString() {
		return namedNode.toString();
	}

	@Override
	public int compareTo(Field that) {
		return toString().compareTo(that.toString());
	}
}
