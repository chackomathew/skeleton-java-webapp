/*
 * 
 */

package com.devops.poc.config;

import com.devops.poc.logging.LoggingFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @author
 */
public class WebConfig implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        createLoggingFilter(servletContext);
    }

    private void createLoggingFilter(ServletContext servletContext) { //TODO

        FilterRegistration.Dynamic logging = servletContext.addFilter("logging", new LoggingFilter());


        EnumSet<DispatcherType> dispatcherTypeEnumSet = EnumSet.of(DispatcherType.REQUEST);
        logging.addMappingForServletNames(dispatcherTypeEnumSet, true, "dispatcher");
    }

}
