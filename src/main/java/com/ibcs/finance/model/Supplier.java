package com.ibcs.finance.model;

import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name= AppNamespaceSet.FINANCIAL_MODULE + "_supplier")
@DiscriminatorValue("supplier")
public class Supplier extends Parties {

    private String supplierNumber;

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

}
