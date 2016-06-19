package com.ibcs.base.dao;

import com.ibcs.base.dao.finder.FinderArgumentTypeFactory;
import com.ibcs.base.dao.finder.FinderNamingStrategy;
import com.ibcs.base.dao.finder.impl.SimpleFinderArgumentTypeFactory;
import com.ibcs.base.dao.finder.impl.SimpleFinderNamingStrategy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.annotation.PostConstruct;

/**
 * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula on 5/15/2016.
 */
public abstract class HibernateSessionUtil {

    /*@Autowired
    protected SessionFactory sessionFactory;

    protected Session session;

    private FinderNamingStrategy namingStrategy = new SimpleFinderNamingStrategy(); // Default. Can override in config

    private FinderArgumentTypeFactory argumentTypeFactory = new SimpleFinderArgumentTypeFactory(); // Default. Can override in config

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public FinderNamingStrategy getNamingStrategy() {
        return namingStrategy;
    }

    public void setNamingStrategy(FinderNamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    public FinderArgumentTypeFactory getArgumentTypeFactory() {
        return argumentTypeFactory;
    }

    public void setArgumentTypeFactory(FinderArgumentTypeFactory argumentTypeFactory) {
        this.argumentTypeFactory = argumentTypeFactory;
    }

    protected Session getSession() {
        return session;
    }

    @PostConstruct
    public void init(){
        session = sessionFactory.getCurrentSession();
    }*/

}
