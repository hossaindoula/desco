package com.ibcs.common.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DESCO_KHATH")
public class DescoKhath {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESCO_KHATH_SEQ")
	@SequenceGenerator(name = "DESCO_KHATH_SEQ", sequenceName = "DESCO_KHATH_SEQ", allocationSize = 1, initialValue = 1)
	private Integer id = 0;

	@Column(name = "khath_name")
	private String khathName;

	@Column(name = "khath_code")
	private String khathCode;
	
	@Column(name = "reference_no")
	private String referenceNo;

	@Column(name = "description")
	private String description;

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

	public String getKhathName() {
		return khathName;
	}

	public void setKhathName(String khathName) {
		this.khathName = khathName;
	}
	
	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKhathCode() {
		return khathCode;
	}

	public void setKhathCode(String khathCode) {
		this.khathCode = khathCode;
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

}
