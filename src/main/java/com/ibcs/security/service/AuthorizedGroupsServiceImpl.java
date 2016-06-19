package com.ibcs.security.service;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.dao.AuthorityDao;
import com.ibcs.security.dao.AuthorizedGroupsDao;
import com.ibcs.security.dto.AuthorityBean;
import com.ibcs.security.dto.AuthorizedGroupsBean;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
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
@Qualifier("authorizedGroupsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthorizedGroupsServiceImpl implements AuthorizedGroupsService {

    @Autowired
    private AuthorizedGroupsDao authorizedGroupsDao;

    public boolean save(AuthorizedGroupsBean o) {
        try{
            AuthorizedGroups authorizedGroups = o.clone();
            return authorizedGroupsDao.create(authorizedGroups);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(AuthorizedGroupsBean o) {
        try{
            AuthorizedGroups authorizedGroups = o.clone();
            return authorizedGroupsDao.delete(authorizedGroups);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    public boolean update(AuthorizedGroupsBean o) {
        try{
            AuthorizedGroups authorizedGroups = o.clone();
            return authorizedGroupsDao.update(authorizedGroups);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    public List<AuthorizedGroupsBean> findAll() {
        List<AuthorizedGroups> authorizedGroups = authorizedGroupsDao.findAll();
        List<AuthorizedGroupsBean> authorizedBeen = new ArrayList<AuthorizedGroupsBean>();

        for(AuthorizedGroups authGroup : authorizedGroups){
            AuthorizedGroupsBean authGroups = new AuthorizedGroupsBean();
            authGroups.setId(authGroup.getId());
            authGroups.setName(authGroup.getName());
            authGroups.setDescription(authGroup.getAuthorizationDescription());
            authGroups.setDashboardUrl(authGroup.getDashboardUrl());
            authorizedBeen.add(authGroups);
        }

        return authorizedBeen;
    }

    public AuthorizedGroupsBean get(Integer id) {
        AuthorizedGroups authGroups = authorizedGroupsDao.get(id);
        AuthorizedGroupsBean authBean = new AuthorizedGroupsBean();
        authBean.setId(authGroups.getId());
        authBean.setName(authGroups.getName());
        authBean.setDescription(authGroups.getAuthorizationDescription());
        authBean.setDashboardUrl(authGroups.getDashboardUrl());

        return authBean;
    }

    public ModelForm getModel() {
        return new AuthorityBean();
    }
}
