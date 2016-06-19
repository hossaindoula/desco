package com.ibcs.security.dto;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;

/**
 * Created by Dell on 6/11/2016.
 */
public class AuthorizedGroupsBean extends ModelForm implements Cloneable {

    private String name;
    private String description;
    private String dashboardUrl;

    public AuthorizedGroupsBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDashboardUrl() {
        return dashboardUrl;
    }

    public void setDashboardUrl(String dashboardUrl) {
        this.dashboardUrl = dashboardUrl;
    }

    @Override
    public AuthorizedGroups clone() throws CloneNotSupportedException {
        AuthorizedGroupsBean authorityBean = (AuthorizedGroupsBean)super.clone();

        AuthorizedGroups authorizedGroups = new AuthorizedGroups();
        authorizedGroups.setId(authorityBean.getId());
        authorizedGroups.setName(authorityBean.getName());
        authorizedGroups.setAuthorizationDescription(authorityBean.getDescription());
        authorizedGroups.setDashboardUrl(authorityBean.getDashboardUrl());

        return authorizedGroups;
    }

    public ModelForm getModelForm() {
        return new AuthorizedGroupsBean();
    }
}
