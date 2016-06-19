package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/16/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_threshold")
public class ProcurementThreshold extends BaseModel<ProcurementThreshold>{

    private String thresholdName;
    private String thresholdLimit;
    private String abbreviation;

    public String getThresholdName() {
        return thresholdName;
    }

    public void setThresholdName(String thresholdName) {
        this.thresholdName = thresholdName;
    }

    public String getThresholdLimit() {
        return thresholdLimit;
    }

    public void setThresholdLimit(String thresholdLimit) {
        this.thresholdLimit = thresholdLimit;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
