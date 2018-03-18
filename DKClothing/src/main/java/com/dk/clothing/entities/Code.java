package com.dk.clothing.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Code {

	@Temporal(TemporalType.DATE)
	@Column(name="cret_date")
	private Date cretDate;
	
	@Column(name="cret_uid")
	private String cretUid;
	
	@Temporal(TemporalType.DATE)
	@Column(name="updt_date")
	private Date updtDate;

	@Column(name="updt_uid")
	private String updtUid;
	
	public Code() {
		
	}

	public Date getCretDate() {
		return cretDate;
	}

	public void setCretDate(Date cretDate) {
		this.cretDate = cretDate;
	}

	public String getCretUid() {
		return cretUid;
	}

	public void setCretUid(String cretUid) {
		this.cretUid = cretUid;
	}

	public Date getUpdtDate() {
		return updtDate;
	}

	public void setUpdtDate(Date updtDate) {
		this.updtDate = updtDate;
	}

	public String getUpdtUid() {
		return updtUid;
	}

	public void setUpdtUid(String updtUid) {
		this.updtUid = updtUid;
	}
	
}
