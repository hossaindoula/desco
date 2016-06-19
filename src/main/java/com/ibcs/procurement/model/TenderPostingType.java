package com.ibcs.procurement.model;

import com.ibcs.AppConstants;
import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;

/**
 * Created by hossain.doula on 5/8/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_tender_posting_type")
public class TenderPostingType extends BaseModel<TenderPostingType> {

    private String postingType;

    public String getPostingType() {
        return postingType;
    }

    public void setPostingType(String postingType) {
        this.postingType = postingType;
    }

}
