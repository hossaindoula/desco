package com.ibcs.general.model;

import com.ibcs.base.model.BaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hossain.doula on 5/22/2016.
 */

@Entity
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findByName",
                query = "select * from Module mod where mod.name = :name",
                resultClass = Module.class
        ),
        @NamedNativeQuery(
                name = "findByIsMenu",
                query = "select * from Module mod where mod.menu = :active",
                resultClass = Module.class
        )
})
public class Module extends BaseModel<Module> {

    private String name;
    private boolean menu;

    @OneToMany
    private List<ModuleGroup> moduleGroups;

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

    public List<ModuleGroup> getModuleGroups() {
        return moduleGroups;
    }

    public void setModuleGroups(List<ModuleGroup> moduleGroups) {
        this.moduleGroups = moduleGroups;
    }
}
