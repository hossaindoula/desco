package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDao;
import com.ibcs.security.model.User;

public interface UserDao extends InclusiveDao<User,Integer>{

    User get(String userCode);

    User get(String userCode, String password);

}
