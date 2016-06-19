package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDao;
import com.ibcs.security.model.Authority;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */


public interface AuthorityDao extends InclusiveDao<Authority, Integer> {

    Authority findByAuthorityName(String authorityName);

}
