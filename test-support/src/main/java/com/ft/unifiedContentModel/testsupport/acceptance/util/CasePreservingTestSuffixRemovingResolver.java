package com.ft.unifiedContentModel.testsupport.acceptance.util;

import org.jbehave.core.Embeddable;
import org.jbehave.core.io.CasePreservingResolver;

/**
 * <p>
 * Resolves story paths while preserving the Java class case, and removing the 'Test' suffix e.g.:
 * "org.jbehave.core.ICanLoginTest.java" -> "org/jbehave/core/ICanLogin.story".
 * </p>
 */
public class CasePreservingTestSuffixRemovingResolver extends CasePreservingResolver {

    @Override
    protected String resolveName(Class<? extends Embeddable> embeddableClass) {
        String className = embeddableClass.getSimpleName();
        return className.substring(0, className.length() - 4);
    }
    
    @Override
    public String resolve(Class<? extends Embeddable> embeddableClass) {
    	return "**/" + resolveName(embeddableClass) + ".story";
    }
}
