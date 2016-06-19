package com.ibcs.configuration;

import javax.annotation.Resource;
import javax.servlet.*;

import com.ibcs.AppConstants;
import com.ibcs.security.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ro.isdc.wro.extensions.http.SpringWroFilter;
import ro.isdc.wro.http.WroContextFilter;
import ro.isdc.wro.http.WroServletContextListener;


/**
 * This will replace web.xml
 * No need for shitty xml configuration file
 * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula@ibcs-primax.com
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
        implements WebApplicationInitializer {

    private static final Class<?>[] configurationClasses = new Class<?>[]{
            AppConfiguration.class,
            PersistenceConfiguration.class/*,
            CacheConfiguration.class*/
    };

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return configurationClasses;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter[] singleton = {
                /*new CORSFilter(), new AuthenticationFilter()*/
        };
        return singleton;
    }

    public void onStartup(ServletContext container) {

        /*<context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>\WEB-INF\dispatcher-servlet.xml</param-value>
        </context-param>
        <listener>
        <listener-class>
        org.springframework.web.context.ContextLoaderListener
                </listener-class>
        </listener>*/
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();


        //container.addListener();
        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
        rootContext.register(configurationClasses);


        /*container.addListener(WroServletContextListener.class);

        container.addFilter("WroContextFilter", WroContextFilter.class)
                .addMappingForUrlPatterns(null, false, "*//*");


        FilterRegistration webResourceOptimizerFilter = container.
                addFilter("webResourceOptimizer", SpringWroFilter.class);
        webResourceOptimizerFilter.addMappingForUrlPatterns(null, false, "/bundle*//*");
        webResourceOptimizerFilter.setInitParameter("targetBeanName", "wroManagerFactory");*/

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet =
                new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(AppConfiguration.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.
                addServlet("dispatcher",
                        new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }

    private MultipartConfigElement getMultipartConfigElement() {
        return new MultipartConfigElement(
                LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
    }

    private static final String LOCATION = "D:/"; // Temporary location where files will be stored

    private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
    // Beyond that size spring will throw exception.
    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.

    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk

}