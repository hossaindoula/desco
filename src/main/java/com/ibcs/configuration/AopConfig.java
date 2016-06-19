package com.ibcs.configuration;

import com.ibcs.AppConstants;
import com.ibcs.security.aop.AuthenticationAspect;
import com.ibcs.security.aop.AuthorizationAspect;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by hossain.doula on 5/31/2016.
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = AppConstants.BASE_NAME_SPACE)
public class AopConfig {
    @Bean
    public AuthenticationAspect authenticationAspect() {
        return new AuthenticationAspect();
    }

    @Bean
    public AuthorizationAspect authorizationAspect() {
        return new AuthorizationAspect();
    }

    @Bean
    public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator(){

        AnnotationAwareAspectJAutoProxyCreator aop
                = new AnnotationAwareAspectJAutoProxyCreator();
        return aop;
    }
}
