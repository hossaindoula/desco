/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibcs.security.service;

import com.ibcs.base.service.DomainPersistentService;
import com.ibcs.security.dto.UserBean;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.Token;
import com.ibcs.security.model.User;
import java.util.List;

/**
 *
 * @author ronnie
 */
public interface UserDetailsService extends   DomainPersistentService<UserBean, Integer>{

    User findByUserCodeAndPassword(String username, String password);

    User findUserByUserCode(String userCode);

    AuthorizedGroups findByAuthorizedGroupsName(String authorizedGroupsName);

    boolean saveAuthorizedGroups(AuthorizedGroups authorizedGroups);

    int count();

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
