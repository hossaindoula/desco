package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/16/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_item_category")
public class ProcurementItemCategory extends BaseModel<ProcurementItemCategory>{

    private String procurementCategoryName;
    private String abbreviation;

    public String getProcurementCategoryName() {
        return procurementCategoryName;
    }

    public void setProcurementCategoryName(String procurementCategoryName) {
        this.procurementCategoryName = procurementCategoryName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
