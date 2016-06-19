package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType= DiscriminatorType.STRING
)
@DiscriminatorValue(value="parties")
public class Parties extends BaseModel<Parties>{

    private String firstName;
    private String lastName;
    private String address;
    private String partyDescription;
    private String email;
    private String phoneNumber;
    private String otherDetails;

    @ManyToMany
    private List<FinancialTransactions> financialTransactionsList;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPartyDescription() {
        return partyDescription;
    }

    public void setPartyDescription(String partyDescription) {
        this.partyDescription = partyDescription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public List<FinancialTransactions> getFinancialTransactionsList() {
        return financialTransactionsList;
    }

    public void setFinancialTransactionsList(List<FinancialTransactions> financialTransactionsList) {
        this.financialTransactionsList = financialTransactionsList;
    }
}