package com.ibcs.general.model;

import com.ibcs.base.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;

/**
 * Created by hossain.doula on 5/22/2016.
 */

@Entity
public class ModuleGroup extends BaseModel<ModuleGroup> {

    private String name;
    private boolean menu;

    @OneToMany
    private Module module;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
