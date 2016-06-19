package com.ibcs.base.dao;

import com.ibcs.configuration.AppConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula on 5/15/2016.
 */
public abstract class DomainPersistentDao {

    @Autowired
    protected SessionFactory sessionFactory;
    //public SessionFactory sessionFactory;

    /*public DomainPersistentDao(){
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfiguration.class);
        context.refresh();
        sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
    }
*/


    public Session getSession() {
        return sessionFactory.getCurrentSession();
        //return sessionFactory.getCurrentSession();
    }


    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
