package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_cost_allocation")
public class CostAllocation extends BaseModel<CostAllocation>{

    @ManyToOne
    private CostAllocationType type;
    private String code;
    private String uom;
    private Double quantity;
    private Double rate;
    private Double amount;

    @ManyToOne
    private FiscalYear fiscalYear;

    @OneToMany
    private List<CostAllocationDetails> costAllocationDetailsList;

    public CostAllocationType getType() {
        return type;
    }

    public void setType(CostAllocationType type) {
        this.type = type;
    }

    public FiscalYear getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(FiscalYear fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public List<CostAllocationDetails> getCostAllocationDetailsList() {
        return costAllocationDetailsList;
    }

    public void setCostAllocationDetailsList(List<CostAllocationDetails> costAllocationDetailsList) {
        this.costAllocationDetailsList = costAllocationDetailsList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
