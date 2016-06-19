package com.ibcs.procurement.dto;

import com.ibcs.base.view.form.dto.ModelForm;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Created by hossain.doula on 5/16/2016.
 */
public class RequirementNoteMasterDetail extends ModelForm implements Cloneable {

    private int departmentId;
    private int issuedBy;
    private int approvedBy;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date postingDate;
    private List<String> itemCode;
    private List<String> itemName;
    private List<String> unit;
    private List<Integer> quantityRequired;
    private List<Double> estimatedCostUnit;
    private List<Double> estimatedTotalCost;
    private List<Integer> previousYearConsumption;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(int issuedBy) {
        this.issuedBy = issuedBy;
    }

    public int getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public List<String> getItemCode() {
        return itemCode;
    }

    public void setItemCode(List<String> itemCode) {
        this.itemCode = itemCode;
    }

    public List<String> getItemName() {
        return itemName;
    }

    public void setItemName(List<String> itemName) {
        this.itemName = itemName;
    }

    public List<String> getUnit() {
        return unit;
    }

    public void setUnit(List<String> unit) {
        this.unit = unit;
    }

    public List<Integer> getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(List<Integer> quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public List<Double> getEstimatedCostUnit() {
        return estimatedCostUnit;
    }

    public void setEstimatedCostUnit(List<Double> estimatedCostUnit) {
        this.estimatedCostUnit = estimatedCostUnit;
    }

    public List<Double> getEstimatedTotalCost() {
        return estimatedTotalCost;
    }

    public void setEstimatedTotalCost(List<Double> estimatedTotalCost) {
        this.estimatedTotalCost = estimatedTotalCost;
    }

    public List<Integer> getPreviousYearConsumption() {
        return previousYearConsumption;
    }

    public void setPreviousYearConsumption(List<Integer> previousYearConsumption) {
        this.previousYearConsumption = previousYearConsumption;
    }
}
