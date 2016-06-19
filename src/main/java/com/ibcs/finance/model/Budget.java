package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hossain.doula on 5/5/2016.
 */

@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_budget")
public class Budget extends BaseModel<Budget>{

    private String budgetName;

    @ManyToMany
    private List<BudgetItem> budgetItems;
    private String particulars;

    private Double limit;
    private Double originalBudget;
    private Double proposedChanges;
    private Double approvedChanges;
    private Double budgetTransfers;
    private Double currentBudget;
    private Double actualExpenditures;
    private Double commitments;
    private Double estimateToComplete;
    private Double atCompletionCosts;
    private Double previousForecast;
    private Double forecastVariance;

    @ManyToOne
    private FinancialStatement statement;

    @ManyToOne
    private BudgetEvent event;

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public List<BudgetItem> getBudgetItems() {
        return budgetItems;
    }

    public void setBudgetItems(List<BudgetItem> budgetItems) {
        this.budgetItems = budgetItems;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public BudgetEvent getEvent() {
        return event;
    }

    public void setEvent(BudgetEvent event) {
        this.event = event;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public FinancialStatement getStatement() {
        return statement;
    }

    public void setStatement(FinancialStatement statement) {
        this.statement = statement;
    }

    public double getOriginalBudget() {
        return originalBudget;
    }

    public void setOriginalBudget(double originalBudget) {
        this.originalBudget = originalBudget;
    }

    public double getProposedChanges() {
        return proposedChanges;
    }

    public void setProposedChanges(double proposedChanges) {
        this.proposedChanges = proposedChanges;
    }

    public double getApprovedChanges() {
        return approvedChanges;
    }

    public void setApprovedChanges(double approvedChanges) {
        this.approvedChanges = approvedChanges;
    }

    public double getBudgetTransfers() {
        return budgetTransfers;
    }

    public void setBudgetTransfers(double budgetTransfers) {
        this.budgetTransfers = budgetTransfers;
    }

    public double getCurrentBudget() {
        return currentBudget;
    }

    public void setCurrentBudget(double currentBudget) {
        this.currentBudget = currentBudget;
    }

    public double getActualExpenditures() {
        return actualExpenditures;
    }

    public void setActualExpenditures(double actualExpenditures) {
        this.actualExpenditures = actualExpenditures;
    }

    public double getCommitments() {
        return commitments;
    }

    public void setCommitments(double commitments) {
        this.commitments = commitments;
    }

    public double getEstimateToComplete() {
        return estimateToComplete;
    }

    public void setEstimateToComplete(double estimateToComplete) {
        this.estimateToComplete = estimateToComplete;
    }

    public double getAtCompletionCosts() {
        return atCompletionCosts;
    }

    public void setAtCompletionCosts(double atCompletionCosts) {
        this.atCompletionCosts = atCompletionCosts;
    }

    public double getPreviousForecast() {
        return previousForecast;
    }

    public void setPreviousForecast(double previousForecast) {
        this.previousForecast = previousForecast;
    }

    public double getForecastVariance() {
        return forecastVariance;
    }

    public void setForecastVariance(double forecastVariance) {
        this.forecastVariance = forecastVariance;
    }
}
