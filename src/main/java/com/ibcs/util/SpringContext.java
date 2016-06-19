package com.ibcs.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/4/2016.
 */
public class SpringContext implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = context;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
}

