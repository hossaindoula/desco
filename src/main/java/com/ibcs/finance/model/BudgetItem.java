package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/5/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_budget_item")
public class BudgetItem extends BaseModel<BudgetEvent> {

    @ManyToOne
    private BudgetCategory category;
    private Double limit;

    public BudgetCategory getCategory() {
        return category;
    }

    public void setCategory(BudgetCategory category) {
        this.category = category;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
