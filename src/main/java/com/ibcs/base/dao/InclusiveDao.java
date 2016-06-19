package com.ibcs.base.dao;

import com.ibcs.base.model.BaseModel;
import com.ibcs.base.model.Order;
import org.hibernate.criterion.MatchMode;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */
public interface InclusiveDao<T, PK extends Serializable> {

    boolean create(T persistentObject);

    T get(PK id);

    List<T> findAll();

    <T extends BaseModel<?>> List<T> findAll(Class<T> clazz, Order order, String... propertiesOrder);

    boolean update(T persistentObject);

    boolean createOrUpdate(T persistentObject);

    boolean delete(T persistentObject);

    int count(T persistentObject);

    <T extends BaseModel<?>> List<T> findByProperty(Class<T> clazz, String propertyName, Object value);

    <T extends BaseModel<?>> List<T> findByProperty(Class<T> clazz, String propertyName, String value, MatchMode matchMode);

}
