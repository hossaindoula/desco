package com.ibcs.cs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "WORK_ORDER_DTL")
public class WorkOrderDtl {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wk_order_dtl_seq")
	@SequenceGenerator(name = "wk_order_dtl_seq", sequenceName = "wk_order_dtl_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "work_order_mst_id", nullable = false)
	WorkOrderMst workOrderMst;

	@Transient
	private String workOrderNo;

	@Column(name = "work_order_No")
	private String wwNo;

	@Column(name = "item_id")
	private String itemId;

	@Column(name = "description")
	private String description;

	@Column(name = "uom")
	private String uom;

	@Column(name = "item_qty")
	private double itemQty;
	
	@Column(name = "remaining_qty")
	private double remainingQty;

	public double getRemainingQty() {
		return remainingQty;
	}

	public void setRemainingQty(double remainingQty) {
		this.remainingQty = remainingQty;
	}

	@Column(name = "cost")
	private String cost;

	@Column(name = "isActive")
	private boolean active = true;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
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

	public WorkOrderMst getWorkOrderMst() {
		return workOrderMst;
	}

	public void setWorkOrderMst(WorkOrderMst workOrderMst) {
		this.workOrderMst = workOrderMst;
	}

	public double getItemQty() {
		return itemQty;
	}

	public void setItemQty(double itemQty) {
		this.itemQty = itemQty;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getWwNo() {
		return wwNo;
	}

	public void setWwNo(String wwNo) {
		this.wwNo = wwNo;
	}

	/*
	 * public ItemMaster getItemMaster() { return itemMaster; }
	 * 
	 * public void setItemMaster(ItemMaster itemMaster) { this.itemMaster =
	 * itemMaster; }
	 */

}
