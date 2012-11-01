package com.ft.api.ucm.model.v1;

import java.util.Set;

public interface Node<C> {
	
	Set<C> getChildren();
	
}
