package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by hossain.doula on 5/5/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_budget_category")
public class BudgetCategory extends BaseModel<Budget> {

    @ManyToMany
    private List<Supplier> suppliers;

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

}
