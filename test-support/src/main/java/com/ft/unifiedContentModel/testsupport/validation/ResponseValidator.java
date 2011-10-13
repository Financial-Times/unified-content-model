package com.ft.unifiedContentModel.testsupport.validation;

import java.io.InputStream;


public interface ResponseValidator {
	
	boolean isValid(InputStream source);

}
