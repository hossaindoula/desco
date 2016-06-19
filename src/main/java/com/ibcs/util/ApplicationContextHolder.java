package com.ibcs.util;

import com.ibcs.configuration.AppConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/5/2016.
 */
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}