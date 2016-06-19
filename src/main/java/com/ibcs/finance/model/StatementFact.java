package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_statement_fact")
public class StatementFact extends BaseModel<StatementFact>{

    @ManyToOne
    private FinancialStatementDetails details;
    private Date transactionDate;
    private Double amount;

    public FinancialStatementDetails getDetails() {
        return details;
    }

    public void setDetails(FinancialStatementDetails details) {
        this.details = details;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
