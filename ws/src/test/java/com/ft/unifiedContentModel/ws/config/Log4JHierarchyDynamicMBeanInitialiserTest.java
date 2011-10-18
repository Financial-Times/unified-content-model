package com.ft.unifiedContentModel.ws.config;

import org.apache.log4j.Appender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.jmx.HierarchyDynamicMBean;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RepositorySelector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.ws.config.Log4JHierarchyDynamicMBeanInitialiser;
import com.google.common.collect.Iterators;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.Matchers.eq;

import static com.google.common.collect.Lists.newArrayList;

@RunWith(MockitoJUnitRunner.class)
public class Log4JHierarchyDynamicMBeanInitialiserTest {

	private static final String LOGGER_NAME = "TEST";
	private static final Object LOCK = new Object();
	
	@Mock private RepositorySelector mockRepositorySelector;
	@Mock private LoggerRepository mockLoggerRepository;
	@Mock private HierarchyDynamicMBean mockHierarchyDynamicMBean;
	
	@Mock private Appender mockAppender;
	
	private Logger stubLogger;
	
	private Log4JHierarchyDynamicMBeanInitialiser instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Log4JHierarchyDynamicMBeanInitialiser(mockHierarchyDynamicMBean, mockLoggerRepository);
		stubLogger = Logger.getLogger(LOGGER_NAME);
		
		when(mockRepositorySelector.getLoggerRepository()).thenReturn(mockLoggerRepository);
		when(mockLoggerRepository.getLogger(LOGGER_NAME)).thenReturn(stubLogger);

		LogManager.setRepositorySelector(mockRepositorySelector, LOCK);
		
		when(mockLoggerRepository.getCurrentLoggers()).thenReturn(Iterators.asEnumeration(newArrayList(stubLogger).iterator()));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructionFailsWhenNullHierarchyDynamicMBean() {
		new Log4JHierarchyDynamicMBeanInitialiser(null, mockLoggerRepository);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructionFailsWhenNullLoggerRepository() {
		new Log4JHierarchyDynamicMBeanInitialiser(mockHierarchyDynamicMBean, null);
	}
	
	@Test
	public void loggersAddedToMbeanHierarchyIfAppendersAttached() throws Exception {
		stubLogger.addAppender(mockAppender);
		instance.exportLoggers();

		verify(mockHierarchyDynamicMBean).addLoggerMBean(eq(LOGGER_NAME));
	}
	
	@Test
	public void loggersAddedToMbeanHierarchyIfFlagSet() throws Exception {
		instance.setShowAllLoggers(true);
		instance.exportLoggers();

		verify(mockHierarchyDynamicMBean).addLoggerMBean(eq(LOGGER_NAME));
	}

}
