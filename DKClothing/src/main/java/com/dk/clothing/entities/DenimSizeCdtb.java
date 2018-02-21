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
	@Column(name="denim_size_cd")
	private String denimSizeCd;

	@Column(name="denim_size_long_desc")
	private String denimSizeLongDesc;

	@Column(name="denim_size_short_desc")
	private String denimSizeShortDesc;

	//bi-directional many-to-one association to Denim
	@OneToMany(mappedBy="denimSizeCdtb")
	private List<Denim> denims;

	public DenimSizeCdtb() {
	}

	public String getDenimSizeCd() {
		return this.denimSizeCd;
	}

	public void setDenimSizeCd(String denimSizeCd) {
		this.denimSizeCd = denimSizeCd;
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

	public List<Denim> getDenims() {
		return this.denims;
	}

	public void setDenims(List<Denim> denims) {
		this.denims = denims;
	}

	public Denim addDenim(Denim denim) {
		getDenims().add(denim);
		denim.setDenimSizeCdtb(this);

		return denim;
	}

	public Denim removeDenim(Denim denim) {
		getDenims().remove(denim);
		denim.setDenimSizeCdtb(null);

		return denim;
	}

}