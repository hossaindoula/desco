package com.ibcs.base.dao;

import java.io.Serializable;
import java.util.List;

import com.ibcs.base.model.BaseModel;
import com.ibcs.base.model.Order;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hossain.doula<hossaindoula@gmail.com> on 6/8/2016.
 */

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InclusiveDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements InclusiveDao<T, PK> {

    private Class<T> type;

    public InclusiveDaoImpl(SessionFactory sessionFactory, Class<T> type) {
        super.setSessionFactory(sessionFactory);
        this.type = type;
    }

    public Session getSession() {
        return currentSession();
    }

    /**
     * Find an entity by its identifier.
     *
     * @param o
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public boolean create(T o) {
        try{
            getSessionFactory().getCurrentSession().persist(o);

            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    /**
     * Find an entity by its identifier.
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public T get(PK id) {
        T value = (T) getSessionFactory().getCurrentSession().get(type, id);
        if (value == null) {
            return null;
        }

        if (value instanceof HibernateProxy) {
            Hibernate.initialize(value);
            value = (T) ((HibernateProxy) value).getHibernateLazyInitializer().getImplementation();
        }

        return value;
    }

    /**
     * Finds all objects of an entity class.
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public List<T> findAll() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(type);
        return criteria.list();
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public boolean createOrUpdate(T o) {
        if (o instanceof BaseModel) {
            if (((BaseModel) o).isCreation()) {
                getSessionFactory().getCurrentSession().saveOrUpdate(o);

                return true;
            } else {
                getSessionFactory().getCurrentSession().merge(o);

                return true;
            }
        } else {
            throw new RuntimeException("this method support only BaseModel");
        }
    }


    /**
     * Updates particular objects of an entity class.
     *
     * @param o the entity class.
     * @return
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public boolean update(T o) {
        try{
            getSessionFactory().getCurrentSession().merge(o);

            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Deletes particular objects of an entity class.
     *
     * @param o the entity class.
     * @return
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public boolean delete(T o) {
        if (o != null) {
            getSessionFactory().getCurrentSession().delete(o);

            return true;
        } else {
            throw new RuntimeException("Entity Not Found");
        }
    }

    /**
     * Counts total objects of an entity class.
     *
     * @param o the entity class.
     * @return
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public int count(T o){
        List list = getHibernateTemplate().find(
                "select count(*) from " + o.getClass().getSimpleName() + " c");

        return Integer.parseInt(list.get(0).toString());
    }

    /**
     * Finds entities by one of its properties.
     *
     *
     *
     * @param clazz the entity class.
     * @param propertyName the property name.
     * @param value the value by which to find.
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public <T extends BaseModel<?>> List<T> findByProperty(Class<T> clazz,
                                                             String propertyName, Object value) {
        return getSessionFactory().getCurrentSession().createCriteria(clazz)
                .add(Restrictions.eq(propertyName, value)).list();
    }

    /**
     * Finds entities by a String property specifying a MatchMode. This search
     * is case insensitive.
     *
     * @param clazz the entity class.
     * @param propertyName the property name.
     * @param value the value to check against.
     * @param matchMode the match mode: EXACT, START, END, ANYWHERE.
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public <T extends BaseModel<?>> List<T> findByProperty(Class<T> clazz,
                                                             String propertyName, String value,
                                                             MatchMode matchMode) {
        if (matchMode != null){
            return getSessionFactory().getCurrentSession().
                    createCriteria(clazz).add(Restrictions.ilike(propertyName, value, matchMode)).list();
        } else {
            return getSessionFactory().getCurrentSession().
                    createCriteria(clazz).add(Restrictions.ilike(
                    propertyName, value, MatchMode.EXACT)).list();
        }
    }

    /**
     * Finds all objects of a class by the specified order.
     *
     * @param clazz the entity class.
     * @param order the order: ASC or DESC.
     * @param propertiesOrder the properties on which to apply the ordering.
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public <T extends BaseModel<?>> List<T> findAll(Class<T> clazz, Order order,
                                                      String... propertiesOrder) {
        Criteria criteria = getSession().createCriteria(clazz);

        for (String propertyOrder : propertiesOrder) {
            if (order.isAscOrder()) {
                criteria.addOrder(org.hibernate.criterion.Order.asc(propertyOrder));
            } else {
                criteria.addOrder(org.hibernate.criterion.Order.desc(propertyOrder));
            }
        }

        return criteria.list();
    }
}
