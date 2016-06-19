package com.ibcs.procurement.model;

import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by hossain.doula on 5/16/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_summary")
public class ProcurementSummary {

    @Lob
    private List<String> procurementPackageDescription;

    @ManyToOne
    private ProcurementMethod procurementMethod;

    @ManyToOne
    private TenderPostingType tenderPostingType;

    @ManyToOne
    private ProcurementApprovingAuthority approvingAuthority;

    private double estimatedCost;

    @Column(name = "tender_evaluation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tenderEvaluationDate;

    @Column(name = "tender_preparation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tenderPreparationDate;

    @Column(name = "contract_award_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractAwardDate;

    @Column(name = "tentative_completion_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tentativeCompletionDate;

    private String annexure;

    private double provisionForBudget;

    public List<String> getProcurementPackageDescription() {
        return procurementPackageDescription;
    }

    public void setProcurementPackageDescription(List<String> procurementPackageDescription) {
        this.procurementPackageDescription = procurementPackageDescription;
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

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public Date getTenderPreparationDate() {
        return tenderPreparationDate;
    }

    public void setTenderPreparationDate(Date tenderPreparationDate) {
        this.tenderPreparationDate = tenderPreparationDate;
    }

    public Date getTenderEvaluationDate() {
        return tenderEvaluationDate;
    }

    public void setTenderEvaluationDate(Date tenderEvaluationDate) {
        this.tenderEvaluationDate = tenderEvaluationDate;
    }

    public Date getContractAwardDate() {
        return contractAwardDate;
    }

    public void setContractAwardDate(Date contractAwardDate) {
        this.contractAwardDate = contractAwardDate;
    }

    public Date getTentativeCompletionDate() {
        return tentativeCompletionDate;
    }

    public void setTentativeCompletionDate(Date tentativeCompletionDate) {
        this.tentativeCompletionDate = tentativeCompletionDate;
    }

    public String getAnnexure() {
        return annexure;
    }

    public void setAnnexure(String annexure) {
        this.annexure = annexure;
    }

    public double getProvisionForBudget() {
        return provisionForBudget;
    }

    public void setProvisionForBudget(double provisionForBudget) {
        this.provisionForBudget = provisionForBudget;
    }
}
