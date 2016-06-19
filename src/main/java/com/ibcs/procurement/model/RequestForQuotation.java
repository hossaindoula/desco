package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_request_for_quotation")
public class RequestForQuotation extends BaseModel<RequestForQuotation> {

    private String title;
    private String number;

    @Column(name = "request_for_quote_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rfqDate;
    private Double amount;
    private String currency;
    private String shipVia;
    private String shippingPoint;
    private String shippingTerms;
    private String invoicePaymentTerms;
    private String inspectionLevel;
    private String shipToAddress;
    private String awardedToVendor;
    private String primaryContact;
    private String vendorEmail;
    private String vendorPhoneNumber;
    private String buyerComments;

    @ManyToMany
    private List<RequisitionDetail> requisitionDetailList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getRfqDate() {
        return rfqDate;
    }

    public void setRfqDate(Date rfqDate) {
        this.rfqDate = rfqDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getShipVia() {
        return shipVia;
    }

    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    public String getShippingPoint() {
        return shippingPoint;
    }

    public void setShippingPoint(String shippingPoint) {
        this.shippingPoint = shippingPoint;
    }

    public String getShippingTerms() {
        return shippingTerms;
    }

    public void setShippingTerms(String shippingTerms) {
        this.shippingTerms = shippingTerms;
    }

    public String getInvoicePaymentTerms() {
        return invoicePaymentTerms;
    }

    public void setInvoicePaymentTerms(String invoicePaymentTerms) {
        this.invoicePaymentTerms = invoicePaymentTerms;
    }

    public String getInspectionLevel() {
        return inspectionLevel;
    }

    public void setInspectionLevel(String inspectionLevel) {
        this.inspectionLevel = inspectionLevel;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public String getAwardedToVendor() {
        return awardedToVendor;
    }

    public void setAwardedToVendor(String awardedToVendor) {
        this.awardedToVendor = awardedToVendor;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getBuyerComments() {
        return buyerComments;
    }

    public void setBuyerComments(String buyerComments) {
        this.buyerComments = buyerComments;
    }

    public List<RequisitionDetail> getRequisitionDetailList() {
        return requisitionDetailList;
    }

    public void setRequisitionDetailList(List<RequisitionDetail> requisitionDetailList) {
        this.requisitionDetailList = requisitionDetailList;
    }
}
