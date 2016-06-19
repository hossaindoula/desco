package com.ibcs.security.dao;

import java.util.List;

import com.ibcs.base.dao.InclusiveDaoImpl;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.ibcs.security.DESEDE;
import com.ibcs.security.model.User;

@Repository("userDao")
@Scope("singleton")
public class UserDaoImpl extends InclusiveDaoImpl<User, Integer> implements UserDao {

    /*@Autowired
    protected SessionFactory sessionFactory;*/

    @Autowired
    public UserDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @SuppressWarnings("unchecked")
    public User get(String username) throws DataAccessException {
        Criteria usernameCriteria = getSession().createCriteria(User.class)
                .createAlias("token", "tk")
                .add(Restrictions.eq("tk.username", username));

        return (User) usernameCriteria.uniqueResult();
    }


    @SuppressWarnings("unchecked")
    public User get(String username, String password) {
        DESEDE desede = new DESEDE(username);
        Object[] credentials = new Object[2];
        credentials[0] = username;
        credentials[1] = desede.encrypt(password);


        Criteria credentialsCriteria = getSession().createCriteria(User.class)
                .createAlias("token", "tk")
                .add(Restrictions.eq("tk.username", credentials[0]))
                .add(Restrictions.eq("tk.password", credentials[1]));

        return (User) credentialsCriteria.uniqueResult();
    }


    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Query query = getSession().createQuery("from User ");

        return (List<User>)query.list();
    }

    public int count(){
        return getAllUsers().size();
    }

}
