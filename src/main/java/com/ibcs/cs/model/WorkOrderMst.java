package com.ibcs.cs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "WORK_ORDER_MST")
public class WorkOrderMst {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wk_order_mst_seq")
	@SequenceGenerator(name = "wk_order_mst_seq", sequenceName = "wk_order_mst_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(name = "work_order_no")
	private String workOrderNo;

	@Column(name = "contract_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date contractDate;

	@Column(name = "chalan_no")
	private String chalanNo;

	@Column(name = "invoice_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date invoiceDate;

	@Column(name = "supplier_name")
	private String supplierName;
	
	@Column(name = "khath_id")
	private Integer khathId;

	@Column(name = "landing_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date landingDate;

	@Column(name = "delivery_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date deliveryDate;

	@Column(name = "bill_of_landing")
	private String billOfLanding;

	@Column(name = "isActive")
	private boolean active = true;

	@Column(name = "is_psi")
	private boolean psi = true;

	@Column(name = "is_pli")
	private boolean pli = true;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@Column(name = "attachment_1")
	private String attachment1;

	@Column(name = "attachment_2")
	private String attachment2;

	@Column(name = "attachment_3")
	private String attachment3;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public Integer getKhathId() {
		return khathId;
	}

	public void setKhathId(Integer khathId) {
		this.khathId = khathId;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public String getChalanNo() {
		return chalanNo;
	}

	public void setChalanNo(String chalanNo) {
		this.chalanNo = chalanNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Date getLandingDate() {
		return landingDate;
	}

	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}

	public String getBillOfLanding() {
		return billOfLanding;
	}

	public void setBillOfLanding(String billOfLanding) {
		this.billOfLanding = billOfLanding;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getAttachment1() {
		return attachment1;
	}

	public void setAttachment1(String attachment1) {
		this.attachment1 = attachment1;
	}

	public String getAttachment2() {
		return attachment2;
	}

	public void setAttachment2(String attachment2) {
		this.attachment2 = attachment2;
	}

	public String getAttachment3() {
		return attachment3;
	}

	public void setAttachment3(String attachment3) {
		this.attachment3 = attachment3;
	}

	public boolean isPsi() {
		return psi;
	}

	public void setPsi(boolean psi) {
		this.psi = psi;
	}

	public boolean isPli() {
		return pli;
	}

	public void setPli(boolean pli) {
		this.pli = pli;
	}

}
