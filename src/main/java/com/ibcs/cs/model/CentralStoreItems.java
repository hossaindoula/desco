package com.ibcs.cs.model;

import com.ibcs.base.model.BaseModel;

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
@Table(name = "CS_ITEMS_LEDGER")
public class CentralStoreItems {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cs_item_lgr_id_seq")
	@SequenceGenerator(name = "cs_item_lgr_id_seq", sequenceName = "cs_item_lgr_id_seq", allocationSize = 1, initialValue = 1)
	private int id = 0;

	@Column(name = "last_ticket_no")
	private String lastTicketNo;

	@Column(name = "model")
	private String model;

	@Column(name = "section")
	private String section;

	@Column(name = "location")
	private String location;

	@Column(name = "minimum")
	private String minimum;

	@Column(name = "maximum")
	private String maximum;

	@Column(name = "item_id")
	private String itemId;

	@Column(name = "balance")
	private double balance;

	@Column(name = "uom")
	private String uom;

	@Column(name = "isActive")
	private boolean active = true;

	@Column(name = "remarks")
	private String remarks;


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

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
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

	public String getLastTicketNo() {
		return lastTicketNo;
	}

	public void setLastTicketNo(String lastTicketNo) {
		this.lastTicketNo = lastTicketNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMinimum() {
		return minimum;
	}

	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}

	public String getMaximum() {
		return maximum;
	}

	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
