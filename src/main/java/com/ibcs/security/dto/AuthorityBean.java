package com.ibcs.security.dto;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.model.Authority;

/**
 * Created by Dell on 6/11/2016.
 */
public class AuthorityBean extends ModelForm implements Cloneable {

    private String name;
    private String description;

    public AuthorityBean() {
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

    @Override
    public Authority clone() throws CloneNotSupportedException {
        AuthorityBean authorityBean = (AuthorityBean)super.clone();

        Authority authority = new Authority();
        authority.setName(authorityBean.getName());
        authority.setAuthorityDescription(authorityBean.getDescription());

        return authority;
    }

    public ModelForm getModelForm() {
        return new AuthorityBean();
    }
}
