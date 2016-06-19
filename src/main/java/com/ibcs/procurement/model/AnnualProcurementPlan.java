package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;
import com.ibcs.finance.model.FiscalYear;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */
@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_annual_procurement_plan")
public class AnnualProcurementPlan extends BaseModel<AnnualProcurementPlan>{

    private String name;

    @ManyToOne
    private FiscalYear fiscalYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FiscalYear getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(FiscalYear fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
}
