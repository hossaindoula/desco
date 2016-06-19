package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;

/**
 * Created by hossain.doula on 5/8/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_approving_authority")
public class ProcurementApprovingAuthority extends BaseModel<ProcurementApprovingAuthority>{

    private String authorityName;

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

}
