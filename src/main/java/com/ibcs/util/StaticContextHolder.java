package com.ibcs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/4/2016.
 */
public class StaticContextHolder implements BeanFactoryAware {

    private final Logger logger = LoggerFactory.getLogger(StaticContextHolder.class);

    public static BeanFactory CONTEXT;

    public StaticContextHolder() {
    }

    public static Object getBean(String s) throws BeansException {
        return CONTEXT.getBean(s);
    }

    public static <T> T getBean(String s, Class<T> tClass) throws BeansException {
        return CONTEXT.getBean(s, tClass);
    }

    public static <T> T getBean(Class<T> tClass) throws BeansException {
        return CONTEXT.getBean(tClass);
    }

    public static Object getBean(String s, Object... objects) throws BeansException {
        return CONTEXT.getBean(s, objects);
    }

    public static boolean containsBean(String s) {
        return CONTEXT.containsBean(s);
    }


    public void setBeanFactory(BeanFactory applicationContext) throws BeansException {
        //logger.assertNull(CONTEXT, "CONTEXT is not null. Double Spring context creation?");
        CONTEXT = applicationContext;
    }
}
