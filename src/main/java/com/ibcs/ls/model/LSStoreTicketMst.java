package com.ibcs.ls.model;

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

@Entity
@Table(name = "LS_STORE_TICKET_MST")
public class LSStoreTicketMst {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ls_st_mst_id_seq")
	@SequenceGenerator(name = "ls_st_mst_id_seq", sequenceName = "ls_st_mst_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(name = "ticket_no", nullable = true)
	private String ticketNo;

	@Column(name = "store_ticket_type", nullable = false)
	private String storeTicketType;

	@Column(name = "operation_id", nullable = false)
	private String operationId;

	@Column(name = "received_from")
	private String receivedFrom;

	@Column(name = "work_order_no")
	private String workOrderNo;

	@Column(name = "work_order_date")
	@Temporal(TemporalType.TIMESTAMP)
	// @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a z")
	private Date workOrderDate;

	@Column(name = "received_by")
	private String receivedBy;

	@Column(name = "ticket_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ticketDate;

	@Column(name = "return_by")
	private String returnBy;

	@Column(name = "return_for")
	private String returnFor;

	@Column(name = "issued_to")
	private String issuedTo;

	@Column(name = "issued_for")
	private String issuedFor;

	@Column(name = "issued_by")
	private String issuedBy;

	@Column(name = "gate_pass")
	private String gatePass;

	@Column(name = "flag")
	private boolean flag = false;

	@Column(name = "status")
	private String status;

	@Column(name = "isActive")
	private boolean active = true;

	@Column(name = "isApproved")
	private boolean approved = false;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "khath_id")
	private Integer khathId;

	@Column(name = "khath_name")
	private String khathName;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getStoreTicketType() {
		return storeTicketType;
	}

	public void setStoreTicketType(String storeTicketType) {
		this.storeTicketType = storeTicketType;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getReceivedFrom() {
		return receivedFrom;
	}

	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	public String getReturnBy() {
		return returnBy;
	}

	public void setReturnBy(String returnBy) {
		this.returnBy = returnBy;
	}

	public String getReturnFor() {
		return returnFor;
	}

	public void setReturnFor(String returnFor) {
		this.returnFor = returnFor;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}

	public String getIssuedFor() {
		return issuedFor;
	}

	public void setIssuedFor(String issuedFor) {
		this.issuedFor = issuedFor;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getWorkOrderDate() {
		return workOrderDate;
	}

	public void setWorkOrderDate(Date workOrderDate) {
		this.workOrderDate = workOrderDate;
	}

	public String getGatePass() {
		return gatePass;
	}

	public void setGatePass(String gatePass) {
		this.gatePass = gatePass;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getKhathId() {
		return khathId;
	}

	public void setKhathId(Integer khathId) {
		this.khathId = khathId;
	}

	public String getKhathName() {
		return khathName;
	}

	public void setKhathName(String khathName) {
		this.khathName = khathName;
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

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
