package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;
import com.ibcs.organization.model.Department;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_purchase_requisition")
public class PurchaseRequisition extends BaseModel<PurchaseRequisition> {

    @ManyToOne
    private Department department;
    private String procurementProposal;
    private String purposeOfProcurement;

    @ManyToOne
    private ProcurementMethod procurementMethod;

    private Date purchaseDate;

    private String detailDescription; //attachment

    private String recommendation; //attachment

    @ManyToOne
    private ProcurementApprovingAuthority procurementApprovingAuthority;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getProcurementProposal() {
        return procurementProposal;
    }

    public void setProcurementProposal(String procurementProposal) {
        this.procurementProposal = procurementProposal;
    }

    public String getPurposeOfProcurement() {
        return purposeOfProcurement;
    }

    public void setPurposeOfProcurement(String purposeOfProcurement) {
        this.purposeOfProcurement = purposeOfProcurement;
    }

    public ProcurementMethod getProcurementMethod() {
        return procurementMethod;
    }

    public void setProcurementMethod(ProcurementMethod procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public ProcurementApprovingAuthority getProcurementApprovingAuthority() {
        return procurementApprovingAuthority;
    }

    public void setProcurementApprovingAuthority(ProcurementApprovingAuthority procurementApprovingAuthority) {
        this.procurementApprovingAuthority = procurementApprovingAuthority;
    }
}
