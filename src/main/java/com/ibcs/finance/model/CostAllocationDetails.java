package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_cost_allocation_details")
public class CostAllocationDetails extends BaseModel<CostAllocationDetails> {

    private String particulars;
    private Double amount;

    @ManyToOne
    private CostAllocation costAllocation;

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public CostAllocation getCostAllocation() {
        return costAllocation;
    }

    public void setCostAllocation(CostAllocation costAllocation) {
        this.costAllocation = costAllocation;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
