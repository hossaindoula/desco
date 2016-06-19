package com.ibcs.util;

import com.ibcs.security.SessionBeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/4/2016.
 */
public class ApplicationContextUtils implements ApplicationContextAware {

    @Resource
    private static ServletContext servletContext;

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public static ApplicationContext beanFactory(){
        return  WebApplicationContextUtils
                        .getRequiredWebApplicationContext(servletContext);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}