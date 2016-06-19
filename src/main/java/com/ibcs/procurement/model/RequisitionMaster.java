package com.ibcs.procurement.model;

import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = AppNamespaceSet.PROCUREMENT_MODULE + "_requisition_master")
public class RequisitionMaster {
	
	@Column(name = "PRF_NO", unique=true, nullable=false)
	private String prfNo;
	
	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss a")
	private Date requisitionDate;
	
	@Column(name = "requisitionOfficer")
	private String requisitionOfficer;
	
	@Column(name = "department_from")
	private String departmentFrom;
	
	@Column(name = "requisition_to")
	private String requisitionTo;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "justification")
	private String justification;

	public String getPrfNo() {
		return prfNo;
	}

	public void setPrfNo(String prfNo) {
		this.prfNo = prfNo;
	}

	public Date getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public String getRequisitionOfficer() {
		return requisitionOfficer;
	}

	public void setRequisitionOfficer(String requisitionOfficer) {
		this.requisitionOfficer = requisitionOfficer;
	}

	public String getDepartmentFrom() {
		return departmentFrom;
	}

	public void setDepartmentFrom(String departmentFrom) {
		this.departmentFrom = departmentFrom;
	}

	public String getRequisitionTo() {
		return requisitionTo;
	}

	public void setRequisitionTo(String requisitionTo) {
		this.requisitionTo = requisitionTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}		

}
