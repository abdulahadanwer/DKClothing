package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ladies_denim_size_cdtb database table.
 * 
 */
@Entity
@Table(name="ladies_denim_size_cdtb")
@NamedQuery(name="LadiesDenimSizeCdtb.findAll", query="SELECT l FROM LadiesDenimSizeCdtb l")
public class LadiesDenimSizeCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ladies_denim_size_cd")
	private Integer ladiesDenimSizeCd;

	@Column(name="denim_size_long_desc")
	private String denimSizeLongDesc;

	@Column(name="denim_size_short_desc")
	private String denimSizeShortDesc;


	public LadiesDenimSizeCdtb() {
	}

	public Integer getLadiesDenimSizeCd() {
		return this.ladiesDenimSizeCd;
	}

	public void setLadiesDenimSizeCd(Integer ladiesDenimSizeCd) {
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