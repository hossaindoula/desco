package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_requisition_details")
public class RequisitionDetail extends BaseModel<RequisitionDetail> {
	
	@Column(name = "item_Name")
	private String itemName;
	
	@Column(name = "item_Code")
	private String itemCode;
	
	@Column(name = "uom")
	private String uom;
	
	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "cost_Center")
	private String costCenter;
	
	@ManyToOne
    @JoinColumn(name="requisition_id")
	private RequisitionMaster requisitionMaster;
	
	@Transient
	private int requisitionId;
	
	@Column(name = "remarks")
	private String remarks;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public int getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(int requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public RequisitionMaster getRequisitionMaster() {
		return requisitionMaster;
	}

	public void setRequisitionMaster(RequisitionMaster requisitionMaster) {
		this.requisitionMaster = requisitionMaster;
	}
}
