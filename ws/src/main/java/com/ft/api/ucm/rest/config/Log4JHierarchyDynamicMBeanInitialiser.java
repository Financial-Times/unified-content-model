package com.ft.api.ucm.rest.config;

// import org.apache.log4j.Appender;
// import org.apache.log4j.Logger;
// import org.apache.log4j.helpers.NullEnumeration;
// import org.apache.log4j.spi.LoggerRepository;
// import org.apache.log4j.jmx.HierarchyDynamicMBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4JHierarchyDynamicMBeanInitialiser {

  private static final Logger log =
      LoggerFactory.getLogger(Log4JHierarchyDynamicMBeanInitialiser.class);
  //
  //	private HierarchyDynamicMBean hierarchyDynamicMBean;
  //	private LoggerRepository loggerRepository;
  //	private boolean showAllLoggers = false;
  //
  //	public Log4JHierarchyDynamicMBeanInitialiser(HierarchyDynamicMBean hierarchyDynamicMBean,
  // LoggerRepository loggerRepository) {
  //		notNull(hierarchyDynamicMBean);
  //		notNull(loggerRepository);
  //		this.hierarchyDynamicMBean = hierarchyDynamicMBean;
  //		this.loggerRepository = loggerRepository;
  //	}
  //
  //	public void setShowAllLoggers(boolean showAllLoggers) {
  //		this.showAllLoggers = showAllLoggers;
  //	}
  //
  //	@PostConstruct
  //	public void exportLoggers() {
  //		addAllLoggersToMbeanHierarchy();
  //	}
  //
  //	@SuppressWarnings("unchecked")
  //	private void addAllLoggersToMbeanHierarchy() {
  //		List<Logger> loggers =
  // Lists.newArrayList(Iterators.forEnumeration(loggerRepository.getCurrentLoggers()));
  //		for (Logger logger : loggers) {
  //			if (showLogger(logger)) {
  //				hierarchyDynamicMBean.addLoggerMBean(logger.getName());
  //			}
  //			log.debug(logger.getName() + " exposed for remote configuration via JMX");
  //		}
  //	}
  //
  //	private boolean showLogger(Logger logger) {
  //		return showAllLoggers || isLoggerConfiguredInLog4jXml(logger);
  //	}
  //
  //	@SuppressWarnings("unchecked")
  //	private boolean isLoggerConfiguredInLog4jXml(Logger logger) {
  //		Enumeration<Appender> enumeration = logger.getAllAppenders();
  //		return !(enumeration instanceof NullEnumeration);
  //	}
}
