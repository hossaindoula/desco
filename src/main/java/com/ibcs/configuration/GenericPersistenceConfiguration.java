package com.ibcs.configuration;

import com.ibcs.AppConstants;
import com.ibcs.base.dao.finder.impl.ExtendedFinderNamingStrategy;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.FieldRetrievingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by hossain.doula on 5/30/2016.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({ AppConstants.BASE_NAME_SPACE })
public class GenericPersistenceConfiguration {

    @Bean(name = "extendedFinderNamingStrategy")
    public ExtendedFinderNamingStrategy transferService() {
        return new ExtendedFinderNamingStrategy();
    }

    @Autowired
    @Bean(name = "namingStrategy")
    public FieldRetrievingFactoryBean fieldRetrievingFactoryBean(){
        FieldRetrievingFactoryBean fieldRetrievingFactoryBean = new FieldRetrievingFactoryBean();
        fieldRetrievingFactoryBean.setStaticField("org.hibernate.cfg.ImprovedNamingStrategy.INSTANCE");
        return fieldRetrievingFactoryBean;
    }

    @Bean(name = "improvedNamingStrategy")
    public NamingStrategy improvedNamingStrategy(){
        return ImprovedNamingStrategy.INSTANCE;
    }
}
