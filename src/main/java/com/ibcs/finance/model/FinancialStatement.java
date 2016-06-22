package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@DiscriminatorColumn(name = AppNamespaceSet.FINANCIAL_MODULE + "_statement_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class FinancialStatement extends BaseModel<FinancialStatement>{

    private String name;

    public FinancialStatement(){
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
