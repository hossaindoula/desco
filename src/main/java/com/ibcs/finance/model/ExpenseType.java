package com.ibcs.finance.model;


import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_expense_type")
public class ExpenseType extends BaseModel<ExpenseType>{

	private String expenseType;

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

}
