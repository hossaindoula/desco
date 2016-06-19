package com.ibcs.finance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name="customer")
@DiscriminatorValue("customer")
public class Customer extends Parties {

    private String customerNumber;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
