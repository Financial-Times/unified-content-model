package com.ft.api.ucm.core.log;


import org.slf4j.LoggerFactory;

public class SystemSupportLogger implements SupportLogger {

    private org.slf4j.Logger logger;

    public SystemSupportLogger(Class clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    @Override
    public void error(String s) {
        if (logger.isErrorEnabled()){
            logger.error(s);
        }

    }
}
