package com.ibcs.util;

import com.ibcs.security.service.UserDetailsServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/5/2016.
 */
public class SpringBeanManager extends ApplicationObjectSupport {

    /** Name of application context bean. */
//    private static final String SOME_BEAN = "someBean";

    /** Name of application context bean. */
//    private static final String ANOTHER_BEAN = "anotherBean";

    /** Reference to application context inside the singleton. */
    private static ApplicationContext applicationContext;

    /** Static inner class that holds a SpringBeanManager object. */
    private static class SpringBeanManagerHolder {
        private static SpringBeanManager instance = new SpringBeanManager();
    }

    /** Default construtor. This class should not be instantiated externally. */
    private SpringBeanManager() {
        super();
    }

    /**
     * Returning the singleton instance.
     *
     * @return The instance.
     */
    public static SpringBeanManager getInstance() {
        return SpringBeanManagerHolder.instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initApplicationContext() throws BeansException {
        /*AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.stop();
        ConfigurableListableBeanFactory factory = rootContext.getBeanFactory();
        factory.registerSingleton("userDetailsService", UserDetailsServiceImpl.class);
        rootContext.start();
        SpringBeanManagerHolder.instance.applicationContext = rootContext;*/
    }

    /**
     * Fetches the someBean bean from applicationContext.
     *
     * @return The someBean.
     */
    /*public SomeBean getSomeBean() {
        return (SomeBean) applicationContext.getBean(SOME_BEAN);
    }*/

    /**
     * Fetches the anotherBean bean from applicationContext.
     *
     * @return The anotherBean.
     */
    /*public AnotherBean getAnotherBean() {
        return (AnotherBean) applicationContext.getBean(ANOTHER_BEAN);
    }*/
}