package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_general_ledger")
public class GeneralLedger extends BaseModel<GeneralLedger>{

    @Column(name = "gl_entry_id", unique = true)
    private String glEntryId;

    @ManyToOne
    private AccountCharts chartOfAccounts;
    private Double entryAmount;
    private String entryDescription;
    private String otherDetails;
	private Date postingDate;
	private Double debit;
	private Double credit;
	private Date fiscalPeriod;

    public String getGlEntryId() {
        return glEntryId;
    }

    public void setGlEntryId(String glEntryId) {
        this.glEntryId = glEntryId;
    }

    public AccountCharts getChartOfAccounts() {
        return chartOfAccounts;
    }

    public void setChartOfAccounts(AccountCharts chartOfAccounts) {
        this.chartOfAccounts = chartOfAccounts;
    }

    public double getEntryAmount() {
        return entryAmount;
    }

    public void setEntryAmount(double entryAmount) {
        this.entryAmount = entryAmount;
    }

    public String getEntryDescription() {
        return entryDescription;
    }

    public void setEntryDescription(String entryDescription) {
        this.entryDescription = entryDescription;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

}
