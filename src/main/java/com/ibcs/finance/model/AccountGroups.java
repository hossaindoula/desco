package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_account_groups")
public class AccountGroups extends BaseModel<AccountGroups>{

    @Column(name = "account_group_name", unique = true) //Asset accounts, Liability accounts
    private String accountGroupName;
    private String firstNumber;
    private String lastNumber;

    public String getAccountGroupName() {
        return accountGroupName;
    }

    public void setAccountGroupName(String accountGroupName) {
        this.accountGroupName = accountGroupName;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(String lastNumber) {
        this.lastNumber = lastNumber;
    }
}
