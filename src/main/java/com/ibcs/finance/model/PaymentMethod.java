package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/5/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_payment_method")
public class PaymentMethod extends BaseModel<PaymentMethod>{

    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
