package com.ibcs.security.service;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.dao.AuthorityDao;
import com.ibcs.security.dto.AuthorityBean;
import com.ibcs.security.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 6/11/2016.
 */

@Service
@Qualifier("authorityService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;

    public boolean save(AuthorityBean o) {
        try{
            Authority authority = o.clone();
            authorityDao.create(authority);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(AuthorityBean o) {
        return false;
    }

    public boolean update(AuthorityBean o) {
        return false;
    }

    public List<AuthorityBean> findAll() {
        List<Authority> authorities = authorityDao.findAll();
        List<AuthorityBean> authorityBeen = new ArrayList<AuthorityBean>();

        for(Authority authority : authorities){
            AuthorityBean authorityBean = new AuthorityBean();
            authorityBean.setId(authority.getId());
            authorityBean.setName(authority.getName());
            authorityBean.setDescription(authority.getAuthorityDescription());
            authorityBeen.add(authorityBean);
        }

        return authorityBeen;
    }

    public AuthorityBean get(Integer id) {
        Authority authority = authorityDao.get(id);
        AuthorityBean authorityBean = new AuthorityBean();
        authorityBean.setId(authority.getId());
        authorityBean.setName(authority.getName());
        authorityBean.setDescription(authority.getAuthorityDescription());
        return authorityBean;
    }

    public ModelForm getModel() {
        return new AuthorityBean();
    }
}
