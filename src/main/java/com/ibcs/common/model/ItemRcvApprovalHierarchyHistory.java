package com.ibcs.common.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ITEM_RCV_APP_HIER_HIST")
public class ItemRcvApprovalHierarchyHistory {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_hier_his_id_Seq")
	@SequenceGenerator(name = "app_hier_his_id_Seq", sequenceName = "app_hier_his_id_Seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(name = "operation_name", nullable = false)
	private String operationName;

	@Column(name = "operation_id", nullable = false)
	private String operationId;

	@Column(name = "stage")
	private String stage;

	@Column(name = "return_to")
	private String return_to;

	@Column(name = "return_state")
	private String return_state;

	@Column(name = "c_designation")
	private String cDesignation;

	@Column(name = "c_dept_name")
	private String cDeptName;

	@Column(name = "dept_id")
	private String deptId;

	@Column(name = "c_emp_id")
	private String cEmpId;

	@Column(name = "c_emp_full_name")
	private String cEmpFullName;

	@Column(name = "state_code")
	private Integer stateCode;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "justification")
	private String justification;

	@Column(name = "actual_role_name")
	private String actRoleName;

	@Column(name = "status")
	private String status;

	@Column(name = "isActive")
	private boolean active = true;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "approval_header")
	private String approvalHeader;

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

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationId() {
		return operationId;
	}

	public String getApprovalHeader() {
		return approvalHeader;
	}

	public void setApprovalHeader(String approvalHeader) {
		this.approvalHeader = approvalHeader;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getActRoleName() {
		return actRoleName;
	}

	public void setActRoleName(String actRoleName) {
		this.actRoleName = actRoleName;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getReturn_to() {
		return return_to;
	}

	public void setReturn_to(String return_to) {
		this.return_to = return_to;
	}

	public String getReturn_state() {
		return return_state;
	}

	public void setReturn_state(String return_state) {
		this.return_state = return_state;
	}

	public String getcDesignation() {
		return cDesignation;
	}

	public void setcDesignation(String cDesignation) {
		this.cDesignation = cDesignation;
	}

	public String getcDeptName() {
		return cDeptName;
	}

	public void setcDeptName(String cDeptName) {
		this.cDeptName = cDeptName;
	}

	public String getcEmpId() {
		return cEmpId;
	}

	public void setcEmpId(String cEmpId) {
		this.cEmpId = cEmpId;
	}

	public String getcEmpFullName() {
		return cEmpFullName;
	}

	public void setcEmpFullName(String cEmpFullName) {
		this.cEmpFullName = cEmpFullName;
	}

}
