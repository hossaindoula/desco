package com.ibcs.util;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.ibcs.configuration.AppConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.StandardMethodMetadata;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/5/2016.
 */
public class SpringBean {

    public static ConfigurableListableBeanFactory getBeansFactory() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        /*ConfigurableListableBeanFactory factory = */

        return applicationContext.getBeanFactory();
    }
}
