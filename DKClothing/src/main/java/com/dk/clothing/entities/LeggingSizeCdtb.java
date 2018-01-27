package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the legging_size_cdtb database table.
 * 
 */
@Entity
@Table(name="legging_size_cdtb")
@NamedQuery(name="LeggingSizeCdtb.findAll", query="SELECT l FROM LeggingSizeCdtb l")
public class LeggingSizeCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="legging_size_cd")
	private String leggingSizeCd;

	@Column(name="legging_size_long_desc")
	private String leggingSizeLongDesc;

	@Column(name="legging_size_short_desc")
	private String leggingSizeShortDesc;

	//bi-directional many-to-one association to Legging
	@OneToMany(mappedBy="leggingSizeCdtb")
	private List<Legging> leggings;

	public LeggingSizeCdtb() {
	}

	public String getLeggingSizeCd() {
		return this.leggingSizeCd;
	}

	public void setLeggingSizeCd(String leggingSizeCd) {
		this.leggingSizeCd = leggingSizeCd;
	}

	public String getLeggingSizeLongDesc() {
		return this.leggingSizeLongDesc;
	}

	public void setLeggingSizeLongDesc(String leggingSizeLongDesc) {
		this.leggingSizeLongDesc = leggingSizeLongDesc;
	}

	public String getLeggingSizeShortDesc() {
		return this.leggingSizeShortDesc;
	}

	public void setLeggingSizeShortDesc(String leggingSizeShortDesc) {
		this.leggingSizeShortDesc = leggingSizeShortDesc;
	}

	public List<Legging> getLeggings() {
		return this.leggings;
	}

	public void setLeggings(List<Legging> leggings) {
		this.leggings = leggings;
	}

	public Legging addLegging(Legging legging) {
		getLeggings().add(legging);
		legging.setLeggingSizeCdtb(this);

		return legging;
	}

	public Legging removeLegging(Legging legging) {
		getLeggings().remove(legging);
		legging.setLeggingSizeCdtb(null);

		return legging;
	}

}