package com.ft.api.ucm.v1.model.aspect;

import static org.springframework.util.Assert.notNull;

import java.util.Set;

import com.ft.api.ucm.v1.model.Node;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSortedSet;

final class NamedNode<C> implements Node<C> {

	private String name;
	private Set<C> children;
	
	public NamedNode(String name, Set<C> children) {
		notNull(name);
		notNull(children);
		this.name = name;
		this.children = sortedCopy(children);
	}

	@Override
	public Set<C> getChildren() {
		return children;
	}
	
	@Override
    @SuppressWarnings("rawtypes")
	public boolean equals(Object that) {
		if(that == this){
			return true;
		}
		if(that instanceof NamedNode) {
		    NamedNode thatNode = (NamedNode) that;
			return Objects.equal(name, thatNode.toString());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	private Set<C> sortedCopy(Set<C> aspects) {
		return ImmutableSortedSet.copyOf(aspects);
	}
}
