/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibcs.security.service;

import com.ibcs.base.service.DomainPersistentService;
import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.finance.model.CashFlow;
import com.ibcs.finance.model.FinancialStatement;
import com.ibcs.security.dao.TokenDao;
import com.ibcs.security.dao.UserDao;


import com.ibcs.security.dto.UserBean;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.Token;
import com.ibcs.security.model.User;

import java.util.ArrayList;
import java.util.List;

import com.ibcs.util.ClassFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ronnie
 */

@Service
@Qualifier("userDetailsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenDao tokenDao;

    public User get(int id) {
        return userDao.get(id);
    }

    public User findByUserCodeAndPassword(String username, String password) {
        User user;
        try{
            CashFlow c = new CashFlow();
            c.getName();
            UserBean userBean = new UserBean();
            userBean.setUsername(username);
            userBean.setPassword(password);
            user = userBean.clone();

            return user;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    public User findUserByUserCode(String userCode) {
        return userDao.get(userCode);
    }

    public AuthorizedGroups findByAuthorizedGroupsName(
            String authorizedGroupsName) {
        return null;
    }

    public boolean saveAuthorizedGroups(AuthorizedGroups authorizedGroups) {
        return false;
    }

    public int count(){
        return userDao.count(new User());
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userDao.get(username,password);
    }

    public User findByUsername(String username) {
        return userDao.get(username);
    }

    public boolean save(UserBean o) {
        try {
            User user = new User();
            Token token = new Token();
            token.setUsername(o.getUsername());
            token.setPassword(o.getPassword());
            tokenDao.create(token);

            user.setActive(true);
            user.setToken(token);
            user.setEmail(o.getEmail());
            userDao.create(user);

            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(UserBean o) {
        return false;
    }

    public boolean update(UserBean o) {
        return false;
    }

    public List<UserBean> findAll() {
        List<User> users = userDao.findAll();
        List<UserBean> userBeanList = new ArrayList<UserBean>();
        for(User user : users){
            UserBean userBean = new UserBean();
            userBean.setId(user.getId());
            userBean.setUsername(user.getToken().getUsername());
            userBean.setPassword(user.getToken().getPassword());
            userBean.setEmail(user.getEmail());
            userBeanList.add(userBean);
        }
        return userBeanList;
    }

    public UserBean get(Integer id) {
        return null;
    }

    public UserBean getModel(){
        return new UserBean();
    }
}
