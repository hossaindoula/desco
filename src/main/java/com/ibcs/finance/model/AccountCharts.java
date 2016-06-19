package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_chart_of_accounts")
public class AccountCharts extends BaseModel<AccountCharts> {

    @Column(name = "account_number", unique=true)
    private String accountNumber;

    @ManyToOne
    private AccountGroups accountGroupName;

    @ManyToOne
    private AccountCharts parentAccount;
    private String accountName;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountGroups getAccountGroupName() {
        return accountGroupName;
    }

    public void setAccountGroupName(AccountGroups accountGroupName) {
        this.accountGroupName = accountGroupName;
    }

    public AccountCharts getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(AccountCharts parentAccount) {
        this.parentAccount = parentAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
