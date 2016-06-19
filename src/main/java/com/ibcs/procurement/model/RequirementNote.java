package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;
import com.ibcs.organization.model.Department;
import com.ibcs.security.model.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hossain.doula on 5/8/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_requirement_note")
public class RequirementNote extends BaseModel<RequirementNote> {

    @ManyToOne
    private Department department;

    @ManyToOne
    private User issuedBy;

    @ManyToOne
    private User approvedBy;

    @Column(name = "posting_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postingDate;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(User issuedBy) {
        this.issuedBy = issuedBy;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }
}
