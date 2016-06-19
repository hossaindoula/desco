package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;
import com.ibcs.finance.model.Budget;
import com.ibcs.finance.model.FiscalYear;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_annual_procurement_details")
public class AnnualProcurementDetails extends BaseModel<AnnualProcurementDetails> {

    @OneToMany
    private List<RequirementNote> requirementNotes;
    private String annexure;

    @OneToMany
    private ProcurementMethod procurementMethod;

    @ManyToOne
    private TenderPostingType tenderPostingType;

    @ManyToOne
    private ProcurementApprovingAuthority approvingAuthority;

    @Column(name = "tender_invitation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tenderInvitationDate;

    @Column(name = "tender_evaluation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tenderEvaluationDate;

    @Column(name = "notification_of_award_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notificationOfAwardDate;

    @Column(name = "completion_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completionDate;
    private Double estimatedCost;

    @ManyToOne
    private Budget budget;

    @ManyToOne
    private AnnualProcurementPlan annualProcurementPlan;

    public List<RequirementNote> getRequirementNotes() {
        return requirementNotes;
    }

    public void setRequirementNotes(List<RequirementNote> requirementNotes) {
        this.requirementNotes = requirementNotes;
    }

    public String getAnnexure() {
        return annexure;
    }

    public void setAnnexure(String annexure) {
        this.annexure = annexure;
    }

    public ProcurementMethod getProcurementMethod() {
        return procurementMethod;
    }

    public void setProcurementMethod(ProcurementMethod procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public TenderPostingType getTenderPostingType() {
        return tenderPostingType;
    }

    public void setTenderPostingType(TenderPostingType tenderPostingType) {
        this.tenderPostingType = tenderPostingType;
    }

    public ProcurementApprovingAuthority getApprovingAuthority() {
        return approvingAuthority;
    }

    public void setApprovingAuthority(ProcurementApprovingAuthority approvingAuthority) {
        this.approvingAuthority = approvingAuthority;
    }

    public Date getTenderInvitationDate() {
        return tenderInvitationDate;
    }

    public void setTenderInvitationDate(Date tenderInvitationDate) {
        this.tenderInvitationDate = tenderInvitationDate;
    }

    public Date getTenderEvaluationDate() {
        return tenderEvaluationDate;
    }

    public void setTenderEvaluationDate(Date tenderEvaluationDate) {
        this.tenderEvaluationDate = tenderEvaluationDate;
    }

    public Date getNotificationOfAwardDate() {
        return notificationOfAwardDate;
    }

    public void setNotificationOfAwardDate(Date notificationOfAwardDate) {
        this.notificationOfAwardDate = notificationOfAwardDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public AnnualProcurementPlan getAnnualProcurementPlan() {
        return annualProcurementPlan;
    }

    public void setAnnualProcurementPlan(AnnualProcurementPlan annualProcurementPlan) {
        this.annualProcurementPlan = annualProcurementPlan;
    }
}
