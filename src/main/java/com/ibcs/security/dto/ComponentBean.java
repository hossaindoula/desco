package com.ibcs.security.dto;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.model.Component;

/**
 * Created by Dell on 6/18/2016.
 */
public class ComponentBean extends ModelForm implements Cloneable {

    private String name;
    private String description;

    public ComponentBean() {
    }

    public ComponentBean(String name, String description) {
        this.name = name;
        this.description = description;
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
    public Component clone() throws CloneNotSupportedException {
        ComponentBean componentBean = (ComponentBean)super.clone();

        Component component = new Component();
        component.setId(componentBean.getId());
        component.setComponentName(componentBean.getName());
        component.setDescription(componentBean.getDescription());

        return component;
    }

    public ModelForm getModel() {
        return new ComponentBean();
    }
}
