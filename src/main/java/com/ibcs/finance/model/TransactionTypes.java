package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name= AppNamespaceSet.FINANCIAL_MODULE + "_transaction_types")
public class TransactionTypes extends BaseModel<TransactionTypes>{

    @Column(name = "transaction_type_code", unique = true) //Adjustment, Payment, Refund
    private String transactionTypeCode;
    private String transactionTypeDescription;

    public String getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public void setTransactionTypeCode(String transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public String getTransactionTypeDescription() {
        return transactionTypeDescription;
    }

    public void setTransactionTypeDescription(String transactionTypeDescription) {
        this.transactionTypeDescription = transactionTypeDescription;
    }
}
