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
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_expenses")
public class Expenses extends BaseModel<Expenses>{

    private String purposeOfExpense;
    private Date dateSubmitted;

    @ManyToOne
    private PaymentMethod paymentMethod;
    private Date dateApproved;
    private Date datePaid;
    private Date dateRejected;
    private Double amount;

    public String getPurposeOfExpense() {
        return purposeOfExpense;
    }

    public void setPurposeOfExpense(String purposeOfExpense) {
        this.purposeOfExpense = purposeOfExpense;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public Date getDateRejected() {
        return dateRejected;
    }

    public void setDateRejected(Date dateRejected) {
        this.dateRejected = dateRejected;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
