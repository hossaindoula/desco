package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.security.model.Component;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.NonUniqueResultException;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */

@Repository("componentDao")
@Scope("singleton")
public class ComponentDaoImpl extends InclusiveDaoImpl<Component, Integer> implements ComponentDao {

    @Autowired
    public ComponentDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, Component.class);
    }

    public Component findComponentByName(String componentName) {
        Component component;
        try {
            Query query = getSession().getNamedQuery("findComponentByName");
            query.setString("componentName", componentName);
            component = (Component)query.uniqueResult();
        } catch(NonUniqueResultException ex) {
            throw new RuntimeException("Duplicate component found with the same name : " + componentName);
        }
        if (component == null) {
            throw new RuntimeException("Unable to find component with name:" + componentName);
        }

        return component;
    }
}
