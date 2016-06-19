package com.ibcs.base.dao;

import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.RollbackException;
import javax.transaction.Synchronization;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import com.ibcs.base.exception.HibernateRuntimeException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Class allowing for reuse of Hibernate Session instances within a transaction
 * transaction.
 */
/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/7/2016.
 */
public class HibernateUtil {

    private static Log logger =
            LogFactory.getLog(HibernateUtil.class);

    private static ThreadLocal sessionSynchronizations = new ThreadLocal();

    public Session getSession(){
        logger.info("Trying to create a test connection with the database.");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate_sp.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
        logger.info("Test connection with the database created successfuly.");
        return session;
    }

    public static SessionFactory lookupSessionFactory() throws NamingException {
        InitialContext initCtx = new InitialContext();
        return (SessionFactory) initCtx.lookup("java:/HibernateFactory");
    }

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new AnnotationConfiguration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    /**
     * Gets a session from the given session factory. If a session has already
     * been asked for this session factory in the current JTA transaction, the
     * same session is returned. Else, a new session is created.
     * The returned session will automatically be flushed and closed at the end
     * of the current JTA transaction.
     * @param sessionFactory the factory from which to get the session
     * @return a session associated with the current JTA transaction.
     */
    public static Session getSession(SessionFactory sessionFactory) {
        try {
            Map map = getSessionSynchronizationMap();
            Key key = new Key(sessionFactory, getCurrentTransaction(sessionFactory));
            SessionSynchronization sync = (SessionSynchronization) map.get(key);
            if (sync == null) {
                Session session = sessionFactory.openSession();
                sync = new SessionSynchronization(key, session);
                map.put(key, sync);
                getCurrentTransaction(sessionFactory).registerSynchronization(sync);
            }
            return sync.getSession();
        }
        catch(SystemException e) {
            throw new HibernateRuntimeException(e);
        }
        catch(HibernateException e) {
            throw new HibernateRuntimeException(e);
        }
        catch(RollbackException e) {
            throw new HibernateRuntimeException(e);
        }
    }

    /**
     * Gets the thread local map storing the session synchronizations.
     * The returned map contains Key instances as keys and SessionSynchronization
     * instances as values
     */
    private static Map getSessionSynchronizationMap() {
        Map map = (Map) sessionSynchronizations.get();
        if (map == null) {
            map = new HashMap();
            sessionSynchronizations.set(map);
        }
        return map;
    }

    /**
     * Gets the current JTA transaction.
     * @param sessionFactory the session factory allowing to get the current
     * transaction
     * @return the current JTA transaction
     * @throws SystemException
     */
    private static Transaction getCurrentTransaction(SessionFactory sessionFactory) throws SystemException {
        SessionFactoryImplementor sessionFactoryImpl =
                (SessionFactoryImplementor) sessionFactory;
        TransactionManager txManager = null /*= sessionFactoryImpl.getTransactionManager()*/;
        return txManager.getTransaction();
    }

    /**
     * Closes the given session and removes the session synchronization identified
     * by the given key from its map.
     */
    private static void closeSession(Key key, Session session) throws HibernateException {
        getSessionSynchronizationMap().remove(key);
        session.close();
    }

    /**
     * A class combining a session factory and a JTA transaction. It's used as
     * key in the map of session synchronizations.
     */
    private static class Key {
        private SessionFactory sessionFactory;
        private Transaction transaction;

        public Key(SessionFactory sessionFactory, Transaction transaction) {
            this.sessionFactory = sessionFactory;
            this.transaction = transaction;
        }

        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public Transaction getTransaction() {
            return transaction;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (o instanceof Key) {
                Key k = (Key) o;
                return ((k.transaction == this.transaction)
                        && (k.sessionFactory == this.sessionFactory));
            }
            return false;
        }

        public int hashCode() {
            return (37 * transaction.hashCode()) + sessionFactory.hashCode();
        }
    }

    /**
     * Class allowing to close a session at the end of a JTA transaction.
     */
    private static class SessionSynchronization implements Synchronization {

        private Key key;
        private Session session;

        public SessionSynchronization(Key key, Session session) {
            this.key = key;
            this.session = session;
        }

        /**
         * @see javax.transaction.Synchronization#beforeCompletion()
         */
        public void beforeCompletion() {
            logger.debug("beforeCompletion called");
            try {
                session.flush();
                closeSession(key, session);
                this.session = null;
            }
            catch (HibernateException e) {
                logger.warn("impossible to flush or close the session", e);
                throw new HibernateRuntimeException(e);
            }
        }

        /**
         * @see javax.transaction.Synchronization#afterCompletion(int)
         */
        public void afterCompletion(int status) {
            logger.debug("afterCompletion called");
            if (this.session != null) {
                try {
                    closeSession(key, session);
                    this.session = null;
                }
                catch (HibernateException e) {
                    logger.warn("impossible to close the session", e);
                }
            }
        }

        public Session getSession() {
            return session;
        }
    }


}

