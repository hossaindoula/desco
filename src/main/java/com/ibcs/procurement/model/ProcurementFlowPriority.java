package com.ibcs.procurement.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_flow_priority")
public class ProcurementFlowPriority extends BaseModel<ProcurementFlowPriority>{

	@Column(name = "state_name", unique = true, nullable = false)
	private String stateName;

	@Column(name = "priority", unique = true, nullable = false)
	private int priority;

	@Column(name = "role_name", unique = true, nullable = false)
	private String roleName;

	@Column(name = "remarks")
	private String remarks;

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
