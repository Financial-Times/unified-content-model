package com.ft.api.ucm.rest.config;

import static org.springframework.util.Assert.notNull;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Enumeration;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.NullEnumeration;
import org.apache.log4j.jmx.HierarchyDynamicMBean;
import org.apache.log4j.spi.LoggerRepository;
import org.slf4j.LoggerFactory;

public class Log4JHierarchyDynamicMBeanInitialiser {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Log4JHierarchyDynamicMBeanInitialiser.class);

	private HierarchyDynamicMBean hierarchyDynamicMBean;
	private LoggerRepository loggerRepository;
	private boolean showAllLoggers = false;
	
	public Log4JHierarchyDynamicMBeanInitialiser(HierarchyDynamicMBean hierarchyDynamicMBean, LoggerRepository loggerRepository) {
		notNull(hierarchyDynamicMBean);
		notNull(loggerRepository);
		this.hierarchyDynamicMBean = hierarchyDynamicMBean;
		this.loggerRepository = loggerRepository;
	}
	
	public void setShowAllLoggers(boolean showAllLoggers) {
		this.showAllLoggers = showAllLoggers;
	}
	
	@PostConstruct
	public void exportLoggers() {
		addAllLoggersToMbeanHierarchy();
	}

	@SuppressWarnings("unchecked")
	private void addAllLoggersToMbeanHierarchy() {
		List<Logger> loggers = Lists.newArrayList(Iterators.forEnumeration(loggerRepository.getCurrentLoggers()));
		for (Logger logger : loggers) {
			if (showLogger(logger)) {
				hierarchyDynamicMBean.addLoggerMBean(logger.getName());	
			}
			log.debug(logger.getName() + " exposed for remote configuration via JMX");
		}
	}
	
	private boolean showLogger(Logger logger) {
		return showAllLoggers || isLoggerConfiguredInLog4jXml(logger);
	}
	
	@SuppressWarnings("unchecked")
	private boolean isLoggerConfiguredInLog4jXml(Logger logger) {
		Enumeration<Appender> enumeration = logger.getAllAppenders();
		return !(enumeration instanceof NullEnumeration);
	}
}
