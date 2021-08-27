package com.ft.api.ucm.rest.config;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.collect.Iterators;
import org.apache.log4j.Appender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.jmx.HierarchyDynamicMBean;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RepositorySelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Disabled(
    "This test is being ignore because it uses a static method on LogManager to configure logging. This is not cleaned, which can break "
        + "subsequent tests that invoke code that uses the logging sub system. TODO prevent this test from having side effects")
public class Log4JHierarchyDynamicMBeanInitialiserTest {

  private static final String LOGGER_NAME = "TEST";
  private static final Object LOCK = new Object();

  @Mock private RepositorySelector mockRepositorySelector;
  @Mock private LoggerRepository mockLoggerRepository;
  @Mock private HierarchyDynamicMBean mockHierarchyDynamicMBean;

  @Mock private Appender mockAppender;

  private Logger stubLogger;

  private Log4JHierarchyDynamicMBeanInitialiser instance;

  @BeforeEach
  public void setUp() throws Exception {
    instance =
        new Log4JHierarchyDynamicMBeanInitialiser(mockHierarchyDynamicMBean, mockLoggerRepository);
    stubLogger = Logger.getLogger(LOGGER_NAME);

    when(mockRepositorySelector.getLoggerRepository()).thenReturn(mockLoggerRepository);
    when(mockLoggerRepository.getLogger(LOGGER_NAME)).thenReturn(stubLogger);

    LogManager.setRepositorySelector(mockRepositorySelector, LOCK);

    when(mockLoggerRepository.getCurrentLoggers())
        .thenReturn(Iterators.asEnumeration(newArrayList(stubLogger).iterator()));
  }

  @Test
  public void constructionFailsWhenNullHierarchyDynamicMBean() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Log4JHierarchyDynamicMBeanInitialiser(null, mockLoggerRepository));
  }

  @Test
  public void constructionFailsWhenNullLoggerRepository() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Log4JHierarchyDynamicMBeanInitialiser(mockHierarchyDynamicMBean, null));
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
