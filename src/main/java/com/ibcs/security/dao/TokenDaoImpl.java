package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.security.model.Token;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */

@Repository("tokenDao")
public class TokenDaoImpl extends InclusiveDaoImpl<Token, Integer> implements TokenDao {

    @Autowired
    public TokenDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, Token.class);
    }

}
