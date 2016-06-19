package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */
@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_cost_center")
public class CostCenter extends BaseModel<CostCenter>{

    @Column(unique = true)
    private String name;
    private String description;

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
}
