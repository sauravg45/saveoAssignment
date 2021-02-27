package com.saveo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "MEDICINE_REPOSITORY")
public class Medicine {

	 @Id
	 @Column(name="n_id")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	 
	 @Column(name = "c_name")
	 public String name;
	 
	 @Column(name="c_batch_no")
	 public String batchNo;
	 
	 @Column(name="n_expiry_date")
	 public Long expiryDate;
	 
	 @Column(name="n_balance_qty")
	 public Long balanceQty;
	 
	 @Column(name="c_unique_code")
	 public String uniqueCode;
	 
	 @Column(name="c_schemes")
	 public String schemes;
	 
	 @Column(name="n_mrp")
	 public BigDecimal mrp;
	 
	 
	 @Column(name="c_manufacturer")
	 public String manufacturer;


	 @Column(name="n_code")
	 public Long hsnCode;
	 
	 
	 public Medicine() {
		 super();
	 }

	public Medicine(String name, String batchNo, Long expiryDate, Long balanceQty, String uniqueCode, String schemes,
			BigDecimal mrp, String manufacturer, Long hsnCode) {
		
		this.name = name;
		this.batchNo = batchNo;
		this.expiryDate = expiryDate;
		this.balanceQty = balanceQty;
		this.uniqueCode = uniqueCode;
		this.schemes = schemes;
		this.mrp = mrp;
		this.manufacturer = manufacturer;
		this.hsnCode = hsnCode;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBatchNo() {
		return batchNo;
	}


	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}


	public Long getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Long expiryDate) {
		this.expiryDate = expiryDate;
	}


	public Long getBalanceQty() {
		return balanceQty;
	}


	public void setBalanceQty(Long balanceQty) {
		this.balanceQty = balanceQty;
	}


	public String getUniqueCode() {
		return uniqueCode;
	}


	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}


	public String getSchemes() {
		return schemes;
	}


	public void setSchemes(String schemes) {
		this.schemes = schemes;
	}


	public BigDecimal getMrp() {
		return mrp;
	}


	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public Long getHsnCode() {
		return hsnCode;
	}


	public void setHsnCode(Long hsnCode) {
		this.hsnCode = hsnCode;
	}


	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", balanceQty=" + balanceQty + ", uniqueCode=" + uniqueCode + ", schemes=" + schemes + ", mrp=" + mrp
				+ ", manufacturer=" + manufacturer + ", hsnCode=" + hsnCode + "]";
	}
	 
	 
}
