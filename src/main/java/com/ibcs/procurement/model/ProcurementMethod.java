package com.ibcs.procurement.model;

import com.ibcs.configuration.AppNamespaceSet;
import com.ibcs.util.StringUtils;

import javax.persistence.*;

/**
 * Created by hossain.doula on 5/8/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_method")
public class ProcurementMethod {

    /**
     * DCP -
     * DQM -
     * DPM - Direct Purchase Method
     * RFQ - Request for Quotation
     * RTM -
     * FCM - Framework Method
     * OTM -
     * AMT - Any Method
     */
    private String procureMethod;
    private String abbreviation;

    @ManyToOne
    private ProcurementMethod procurementMethod;

    public String getProcureMethod() {
        return procureMethod;
    }

    public void setProcureMethod(String procureMethod) {
        this.procureMethod = procureMethod;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public ProcurementMethod getProcurementMethod() {
        return procurementMethod;
    }

    public void setProcurementMethod(ProcurementMethod procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public String getClassName(){
        return this.getClassName();
    }
}
