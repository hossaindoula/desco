package com.ibcs.configuration;

import java.io.IOException;
import java.rmi.Naming;
import java.util.Properties;

import javax.sql.DataSource;

import com.ibcs.AppConstants;
import com.ibcs.base.dao.GenericDaoHibernateImpl;
import com.ibcs.base.dao.finder.impl.ExtendedFinderNamingStrategy;
import com.ibcs.base.dao.finder.impl.FinderIntroductionAdvisor;
import com.ibcs.util.ClassFinder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.FieldRetrievingFactoryBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This will configure the persistence level
 * here hibernate is maintained to communicate RDBMS
 * Created by hossain.doula on 5/15/2016.
 */

@Configuration
//@Profile("hibernate")
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan({ AppConstants.BASE_NAME_SPACE })
@PropertySource(value = { "classpath:persistence.properties" })
//@Import(value = {GenericPersistenceConfiguration.class})
public class PersistenceConfiguration {

    @Autowired
    private Environment environment;

    @Autowired
    private BeanFactory beanFactory;

    @Bean
    public NamingStrategy entityNamingStrategy(){
        return new EntityNamingStrategy();
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() throws IOException{
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(AppNamespaceSet.MODEL_NS);
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.afterPropertiesSet();
        //sessionFactory.setNamingStrategy(entityNamingStrategy());
        //sessionFactory.setNamingStrategy(new EntityNamingStrategy());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }


    private Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
                setProperty("hibernate.default_schema", environment.getProperty("hibernate.default_schema"));
                setProperty("hibernate.naming_strategy", environment.getProperty("hibernate.naming_strategy"));
                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /*@Autowired
    @Bean(name = "abstractDao")
    public ProxyFactoryBean proxyFactoryBean(){
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        try{
            proxyFactoryBean.setProxyInterfaces(AppNamespaceSet.classes);
            proxyFactoryBean.setInterceptorNames(AppNamespaceSet.interceptors);
        } catch (ClassNotFoundException cnFex){
            cnFex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return proxyFactoryBean;
    }*/

    /*@Bean(name = "namingStrategy")
    public FieldRetrievingFactoryBean namingStrategy(){
        FieldRetrievingFactoryBean fieldRetrievingFactoryBean = new FieldRetrievingFactoryBean();
        fieldRetrievingFactoryBean.setStaticField("improvedNamingStrategy");
        return fieldRetrievingFactoryBean;
    }*/

}
