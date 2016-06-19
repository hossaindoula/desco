package com.ibcs.base.util;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 * <p>Title: ModelUtils</p>
 *
 * <p>
 * Util class containing several methods used in Hibernate session and beans's manipulations.
 * </p>
 * @author Mohammed Hossain Doula<hosssaindoula@gmail.com>
 */
public class ModelUtils {

    @SuppressWarnings("unchecked")
    public static <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            return null;
        }

        if (entity instanceof HibernateProxy) {
            Hibernate.initialize(entity);
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
        }
        return entity;
    }
}
