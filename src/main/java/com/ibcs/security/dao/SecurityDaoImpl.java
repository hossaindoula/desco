package com.ibcs.security.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibcs.base.dao.DomainPersistentDao;
import com.ibcs.security.model.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("securityDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SecurityDaoImpl extends DomainPersistentDao implements SecurityDao {


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Feature feature){
        try{
            persist(feature);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Feature feature) {
        try{
            getSession().merge(feature);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Feature getFeature(int featureId) {
        return (Feature) getSession().get(Feature.class, featureId);
    }

    public Feature findFeatureByOperation(String operation) {
        Criteria featureCriteria = getSession().createCriteria(Feature.class);
        featureCriteria.add(Restrictions.eq("operation", operation));
        return (Feature) featureCriteria.uniqueResult();
    }

    public List<Feature> findAllFeatures() {
        List<Feature> features = new ArrayList<Feature>();
        try{
            features = getSession().createQuery(" from Feature ").list();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return features;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Feature feature) {
        try{
            getSession().delete(feature);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Authority authority) {
        try{
            persist(authority);

            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Authority authority) {
        try{
            persist(authority);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Authority getAuthority(int authorityId) {
        return (Authority) getSession().get(Authority.class, authorityId);
    }
    public Authority findByAuthorityName(String authorityName){
        Criteria authorityNameCriteria = getSession().createCriteria(Authority.class);
        authorityNameCriteria.add(Restrictions.eq("authorityName", authorityName));
        return (Authority) authorityNameCriteria.uniqueResult();
    }


    public List<Authority> findAllAuthorities() {
        List<Authority> authorities = new ArrayList<Authority>();
        try{
            authorities = getSession().createQuery(" from Authority ").list();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return authorities;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Authority authority) {
        try{
            getSession().delete(authority);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Component component) {
        try{
            persist(component);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Component component) {
        try{
            getSession().merge(component);

            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Component getComponent(int componentId) {
        return (Component) getSession().get(Component.class, componentId);
    }


    public List<Component> findAllComponents() {
        List<Component> components = new ArrayList<Component>();
        try{
            components = getSession().createQuery(" from Component ").list();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return components;
    }

    public Component getComponentById(Long componentId){
        return (Component) getSession().get(Component.class, componentId);
    }


    public Component getComponentByName(String componentName){
        Criteria componentCriteria = getSession().createCriteria(Component.class)
                .add(Restrictions.eq("componentName", componentName));

        return (Component) componentCriteria.uniqueResult();

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Component component) {
        try{
            getSession().delete(component);

            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(AuthorizedGroups authorizedGroups) {
        try{
            persist(authorizedGroups);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(AuthorizedGroups authorizedGroups) {
        try{
            getSession().merge(authorizedGroups);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public AuthorizedGroups getAuthorizedGroups(int authorizedGroupId) {
        return (AuthorizedGroups) getSession().get(AuthorizedGroups.class, authorizedGroupId);
    }

    public List<AuthorizedGroups> findAllAuthorizedGroups() {
        List<AuthorizedGroups> allAuthorizedGroups = new ArrayList<AuthorizedGroups>();
        try{
            allAuthorizedGroups = getSession().createQuery(" from AuthorizedGroups ").list();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return allAuthorizedGroups;
    }

    public List<Authority> findAllAuthorities(List<AuthorizedGroups> authorizedGroups) {
        List<Authority> authorities = new ArrayList<Authority>();
        try{
            authorities = getSession().createQuery(" from Authority ").list();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return authorities;
    }

    public List<Feature> findAllFeatures(List<Authority> authorities) {
        List<Feature> features = new ArrayList<Feature>();
        try{
            features = getSession().createQuery(" from Feature ").list();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return features;
    }
}
