package com.ibcs.base.view.form.dto;


/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/27/2016.
 */
public abstract class ModelForm {

    protected Integer id;

    public boolean isNew() {
        return (this.id == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
