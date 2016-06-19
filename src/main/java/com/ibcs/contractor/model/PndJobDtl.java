package com.ibcs.contractor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PND_JOB_DTL")
public class PndJobDtl {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pnd_job_dtl_id_seq")
	@SequenceGenerator(name = "pnd_job_dtl_id_seq", sequenceName = "pnd_job_dtl_id_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@ManyToOne
	private PndJobMst pndJobMst;
	
	private Integer mstId;
	
	@Column(name = "ITEM_CODE")
	private String itemCode;
	
	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "UOM")
	private String uom;

	@Column(name = "QTY")
	private double quantity;

	@Column(name = "REMAINNING_QUANTITY")
	private double remainningQuantity;

	@Column(name = "OTHERS")
	private Date others;
	

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getRemainningQuantity() {
		return remainningQuantity;
	}

	public void setRemainningQuantity(double remainningQuantity) {
		this.remainningQuantity = remainningQuantity;
	}

	public Date getOthers() {
		return others;
	}

	public void setOthers(Date others) {
		this.others = others;
	}

	public PndJobMst getPndJobMst() {
		return pndJobMst;
	}

	public void setPndJobMst(PndJobMst pndJobMst) {
		this.pndJobMst = pndJobMst;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Integer getMstId() {
		return mstId;
	}

	public void setMstId(Integer mstId) {
		this.mstId = mstId;
	}

}
