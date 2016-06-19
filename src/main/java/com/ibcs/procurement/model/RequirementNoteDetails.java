package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;
import com.ibcs.util.StringUtils;

import javax.persistence.*;

/**
 * Created by hossain.doula on 5/8/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_requirement_note_details")
public class RequirementNoteDetails extends BaseModel<RequirementNoteDetails>{

    private String codeNumber;
    private String itemDescription;
    private String unit;
    private Double requiredQuantity;
    private Double estimatedCostUnit;
    private Double estimatedTotalCost;
    private Double previousYearConsumption;

    @ManyToOne
    private RequirementNote requirementNote;

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(double requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public double getEstimatedCostUnit() {
        return estimatedCostUnit;
    }

    public void setEstimatedCostUnit(double estimatedCostUnit) {
        this.estimatedCostUnit = estimatedCostUnit;
    }

    public double getEstimatedTotalCost() {
        return estimatedTotalCost;
    }

    public void setEstimatedTotalCost(double estimatedTotalCost) {
        this.estimatedTotalCost = estimatedTotalCost;
    }

    public double getPreviousYearConsumption() {
        return previousYearConsumption;
    }

    public void setPreviousYearConsumption(double previousYearConsumption) {
        this.previousYearConsumption = previousYearConsumption;
    }

    public RequirementNote getRequirementNote() {
        return requirementNote;
    }

    public void setRequirementNote(RequirementNote requirementNote) {
        this.requirementNote = requirementNote;
    }

    public String toString(){
        return StringUtils.splitCamelCase(RequirementNoteDetails.class.getSimpleName()) + " created with "
                + "[ item description " + itemDescription + "]" ;
    }
}
