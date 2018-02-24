package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the denim_size_cdtb database table.
 * 
 */
@Entity
@Table(name="ladies_denim_size_cdtb")
@NamedQuery(name="DenimSizeCdtb.findAll", query="SELECT d FROM DenimSizeCdtb d")
public class DenimSizeCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ladies_denim_size_cd")
	private Integer ladiesDenimSizeCd;

	@Column(name="denim_size_long_desc")
	private String denimSizeLongDesc;

	@Column(name="denim_size_short_desc")
	private String denimSizeShortDesc;

	public DenimSizeCdtb() {
	}

	public Integer getDenimSizeCd() {
		return this.ladiesDenimSizeCd;
	}

	public void setDenimSizeCd(Integer ladiesDenimSizeCd) {
		this.ladiesDenimSizeCd = ladiesDenimSizeCd;
	}

	public String getDenimSizeLongDesc() {
		return this.denimSizeLongDesc;
	}

	public void setDenimSizeLongDesc(String denimSizeLongDesc) {
		this.denimSizeLongDesc = denimSizeLongDesc;
	}

	public String getDenimSizeShortDesc() {
		return this.denimSizeShortDesc;
	}

	public void setDenimSizeShortDesc(String denimSizeShortDesc) {
		this.denimSizeShortDesc = denimSizeShortDesc;
	}
}