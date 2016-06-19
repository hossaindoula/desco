package com.ibcs.organization.model;

import com.ibcs.base.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department extends BaseModel<Department>{

	@Column(name = "dept_id")
	private String deptId;

	@Column(name = "parent")
	private String parent;

	@Column(name = "dept_name")
	private String deptName;

	@Column(name = "dept_level")
	private String deptLevel;

	@Column(name = "address")
	private String address;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "email")
	private String email;

	@Column(name = "desco_code")
	private String descoCode;

	@Column(name = "contact_person")
	private String contactPerson;

	@Column(name = "remarks")
	private String remarks;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDescoCode() {
		return descoCode;
	}

	public void setDescoCode(String descoCode) {
		this.descoCode = descoCode;
	}

}
