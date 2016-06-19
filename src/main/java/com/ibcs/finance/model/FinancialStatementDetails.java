package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_financial_statement_details")
public class FinancialStatementDetails extends BaseModel<FinancialStatement> {

    @ManyToOne
    private FinancialStatement statement;

    private int order;

    private String title;
    private String description;
    private String properties;

    public FinancialStatement getStatement() {
        return statement;
    }

    public void setStatement(FinancialStatement statement) {
        this.statement = statement;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
