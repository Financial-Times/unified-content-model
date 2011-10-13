package com.ft.unifiedContentModel.testsupport.validation;

import java.io.InputStream;


public interface ValidationService {
	
	boolean isValid(InputStream text, String type);
	boolean isValid(String text, String type);
	
}
