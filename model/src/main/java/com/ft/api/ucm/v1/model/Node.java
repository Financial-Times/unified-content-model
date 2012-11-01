package com.ft.api.ucm.v1.model;

import java.util.Set;

public interface Node<C> {
	
	Set<C> getChildren();
	
}
