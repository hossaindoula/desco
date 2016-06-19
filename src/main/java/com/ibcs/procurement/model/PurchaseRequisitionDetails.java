package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_purchase_requisition_details")
public class PurchaseRequisitionDetails extends BaseModel<PurchaseRequisitionDetails>{

    private String code;
    private String itemDescription;
    private Date lastPurchaseDate;
    private Double lastPurchaseQuantity;
    private Double stockInBalance;
    private Double presentRequirement;
    private Double lastPurchaseRate;
    private Double estimatedPurchaseRate;
    private Double totalEstimatedCost;

    @ManyToOne
    private PurchaseRequisition purchaseRequisition;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Date getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(Date lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    public Double getLastPurchaseQuantity() {
        return lastPurchaseQuantity;
    }

    public void setLastPurchaseQuantity(Double lastPurchaseQuantity) {
        this.lastPurchaseQuantity = lastPurchaseQuantity;
    }

    public Double getStockInBalance() {
        return stockInBalance;
    }

    public void setStockInBalance(Double stockInBalance) {
        this.stockInBalance = stockInBalance;
    }

    public Double getPresentRequirement() {
        return presentRequirement;
    }

    public void setPresentRequirement(Double presentRequirement) {
        this.presentRequirement = presentRequirement;
    }

    public Double getLastPurchaseRate() {
        return lastPurchaseRate;
    }

    public void setLastPurchaseRate(Double lastPurchaseRate) {
        this.lastPurchaseRate = lastPurchaseRate;
    }

    public Double getEstimatedPurchaseRate() {
        return estimatedPurchaseRate;
    }

    public void setEstimatedPurchaseRate(Double estimatedPurchaseRate) {
        this.estimatedPurchaseRate = estimatedPurchaseRate;
    }

    public Double getTotalEstimatedCost() {
        return totalEstimatedCost;
    }

    public void setTotalEstimatedCost(Double totalEstimatedCost) {
        this.totalEstimatedCost = totalEstimatedCost;
    }

    public PurchaseRequisition getPurchaseRequisition() {
        return purchaseRequisition;
    }

    public void setPurchaseRequisition(PurchaseRequisition purchaseRequisition) {
        this.purchaseRequisition = purchaseRequisition;
    }
}
