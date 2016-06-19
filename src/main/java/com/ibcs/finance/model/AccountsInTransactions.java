package com.ibcs.finance.model;


import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_accounts_in_transactions")
public class AccountsInTransactions extends BaseModel<AccountsInTransactions> {

    @ManyToOne
    private AccountCharts accountCharts;

    @ManyToOne
    private FinancialTransactions financialTransactions;
    private double amount;

    public AccountCharts getAccountCharts() {
        return accountCharts;
    }

    public void setAccountCharts(AccountCharts accountCharts) {
        this.accountCharts = accountCharts;
    }

    public FinancialTransactions getFinancialTransactions() {
        return financialTransactions;
    }

    public void setFinancialTransactions(FinancialTransactions financialTransactions) {
        this.financialTransactions = financialTransactions;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
