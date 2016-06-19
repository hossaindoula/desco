package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.security.model.Authority;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.NonUniqueResultException;
import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */
@Repository("authorityDao")
@Scope("singleton")
public class AuthorityDaoImpl extends InclusiveDaoImpl<Authority, Integer> implements AuthorityDao {

    @Autowired
    public AuthorityDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, Authority.class);
    }

    public Authority findByAuthorityName(String authorityName) {
        Authority authority;
        try {
            Query query = getSession().getNamedQuery("findByAuthorityName");
            query.setString("name", authorityName);
            authority = (Authority)query.uniqueResult();
        } catch(NonUniqueResultException ex) {
            throw new RuntimeException("Duplicate authority found with the same name : " + authorityName);
        }
        if (authority == null) {
            throw new RuntimeException("Unable to find Authority with name:" + authorityName);
        }

        return authority;
    }
}
