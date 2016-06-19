package com.ibcs.tag.report.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 4/16/2016.
 */
public class Report {

    private String upperLeftCornerElem;
    private String belowUpperLeftCornerElem;
    private String logoUrl;
    private String invoiceAutoNumber;
    private Date date = new Date();
    private double amount;
    private Map<String,Object> metaElements;
    private List<Object> nestedElements;
    private String reportType;
    private String terms;

    public String getUpperLeftCornerElem() {
        return upperLeftCornerElem;
    }

    public void setUpperLeftCornerElem(String upperLeftCornerElem) {
        this.upperLeftCornerElem = upperLeftCornerElem;
    }

    public String getBelowUpperLeftCornerElem() {
        return belowUpperLeftCornerElem;
    }

    public void setBelowUpperLeftCornerElem(String belowUpperLeftCornerElem) {
        this.belowUpperLeftCornerElem = belowUpperLeftCornerElem;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getInvoiceAutoNumber() {
        return invoiceAutoNumber;
    }

    public void setInvoiceAutoNumber(String invoiceAutoNumber) {
        this.invoiceAutoNumber = invoiceAutoNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public List<Object> getNestedElements() {
        return nestedElements;
    }

    public void setNestedElements(List<Object> nestedElements) {
        this.nestedElements = nestedElements;
    }

    public Map<String, Object> getMetaElements() {
        return metaElements;
    }

    public void setMetaElements(Map<String, Object> metaElements) {
        this.metaElements = metaElements;
    }
}
