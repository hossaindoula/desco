package com.ibcs.contractor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PND_JOB_MST")
public class PndJobMst {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnd_job_mst_id_seq")
	@SequenceGenerator(name = "pnd_job_mst_id_seq", sequenceName = "pnd_job_mst_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(name = "WO_NUMBER")
	private String woNumber;

	@Column(name = "JOB_NO")
	private String storeTicketNO;

	@Column(name = "JOB_TITTLE")
	private String deptName;

	@Column(name = "JOB_LOCATION")
	private String receivedBy;

	@Column(name = "OTHERS")
	private Date others;

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
