package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.security.model.AuthorizedGroups;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */

@Repository("authorizedGroupsDao")
@Scope("singleton")
public class AuthorizedGroupsDaoImpl extends
        InclusiveDaoImpl<AuthorizedGroups, Integer> implements
        AuthorizedGroupsDao {

    @Autowired
    public AuthorizedGroupsDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
        super(sessionFactory, AuthorizedGroups.class);
    }
}
