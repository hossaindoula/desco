package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.security.model.Feature;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */

@Repository("featureDao")
@Scope("singleton")
public class FeatureDaoImpl extends InclusiveDaoImpl<Feature, Integer> implements FeatureDao {

    @Autowired
    public FeatureDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, Feature.class);
    }

    @SuppressWarnings("unchecked")
    public List<Feature> findAllFeaturesByOperation(String name) {
        Query query = getSession().getNamedQuery("findAllFeaturesByOperation");
        query.setString("operation", name);

        return (List<Feature>)query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Feature> findAllFeaturesByComponent(String name) {
        Query query = getSession().getNamedQuery("findAllFeaturesByComponent");
        query.setString("operation", name);

        return (List<Feature>)query.list();
    }
}
