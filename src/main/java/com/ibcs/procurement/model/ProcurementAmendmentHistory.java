package com.ibcs.procurement.model;

import com.ibcs.AppConstants;
import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;
import com.ibcs.security.model.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hossain.doula on 5/16/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_amendment_history")
public class ProcurementAmendmentHistory extends BaseModel<ProcurementAmendmentHistory> {

    private String amendmentName;

    @ManyToOne
    private ProcurementThreshold threshold;

    @ManyToOne
    private ProcurementItemCategory procurementItemCategory;

    @ManyToOne
    private ProcurementMethod procurementMethod;

    @ManyToOne
    private ProcurementApprovingAuthority approvingAuthority;

    @Column(name = "amendment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date amendmentDate;

    @Column(name = "applied_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appliedDate;

    @ManyToOne
    private User amendedBy;

    public User getAmendedBy() {
        return amendedBy;
    }

    public void setAmendedBy(User amendedBy) {
        this.amendedBy = amendedBy;
    }


    public String getAmendmentName() {
        return amendmentName;
    }

    public void setAmendmentName(String amendmentName) {
        this.amendmentName = amendmentName;
    }

    public ProcurementThreshold getThreshold() {
        return threshold;
    }

    public void setThreshold(ProcurementThreshold threshold) {
        this.threshold = threshold;
    }

    public ProcurementItemCategory getProcurementItemCategory() {
        return procurementItemCategory;
    }

    public void setProcurementItemCategory(ProcurementItemCategory procurementItemCategory) {
        this.procurementItemCategory = procurementItemCategory;
    }

    public ProcurementMethod getProcurementMethod() {
        return procurementMethod;
    }

    public void setProcurementMethod(ProcurementMethod procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public ProcurementApprovingAuthority getApprovingAuthority() {
        return approvingAuthority;
    }

    public void setApprovingAuthority(ProcurementApprovingAuthority approvingAuthority) {
        this.approvingAuthority = approvingAuthority;
    }

    public Date getAmendmentDate() {
        return amendmentDate;
    }

    public void setAmendmentDate(Date amendmentDate) {
        this.amendmentDate = amendmentDate;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }
}
