package com.ft.unifiedContentModel.ws.filter;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ft.unifiedContentModel.ws.filter.UserContextLoggingFilter;

@RunWith(MockitoJUnitRunner.class)
public class UserContextLoggingFilterTest {

    @Mock
    public HttpServletRequest request;

    public static String prefix = "Hello";
    public static String suffix = "Goodbye";
    public static String apiKeyHeader = "apiKeyHeader";
    public static String userIpHeader = "userIpHeader";

    public UserContextLoggingFilter userContextLoggingFilter;

    @Before
    public void setUp(){
        userContextLoggingFilter = new UserContextLoggingFilter();
    }

    @Test
    public void testCreateMessage(){

        when(request.getHeader(UserContextLoggingFilter.API_KEY_HEADER)).thenReturn("apiKeyHeader");
        when(request.getHeader(UserContextLoggingFilter.USER_IP_HEADER)).thenReturn("userIpHeader");
        String s = userContextLoggingFilter.createMessage(request, prefix, suffix);

        assertEquals(s, prefix + UserContextLoggingFilter.API_KEY_LABEL + "=" + apiKeyHeader + " "
                + UserContextLoggingFilter.USER_IP_LABEL  + "=" + userIpHeader+ suffix);

    }


}
