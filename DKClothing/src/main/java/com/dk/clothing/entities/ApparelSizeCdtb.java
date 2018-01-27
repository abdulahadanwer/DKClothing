package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the apparel_size_cdtb database table.
 * 
 */
@Entity
@Table(name="apparel_size_cdtb")
@NamedQuery(name="ApparelSizeCdtb.findAll", query="SELECT a FROM ApparelSizeCdtb a")
public class ApparelSizeCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="apparel_size_cd")
	private String apparelSizeCd;

	@Column(name="apparel_size_long_desc")
	private String apparelSizeLongDesc;

	@Column(name="apparel_size_short_desc")
	private String apparelSizeShortDesc;

	//bi-directional many-to-one association to LadiesApparel
	@OneToMany(mappedBy="apparelSizeCdtb")
	private List<LadiesApparel> ladiesApparels;

	public ApparelSizeCdtb() {
	}

	public String getApparelSizeCd() {
		return this.apparelSizeCd;
	}

	public void setApparelSizeCd(String apparelSizeCd) {
		this.apparelSizeCd = apparelSizeCd;
	}

	public String getApparelSizeLongDesc() {
		return this.apparelSizeLongDesc;
	}

	public void setApparelSizeLongDesc(String apparelSizeLongDesc) {
		this.apparelSizeLongDesc = apparelSizeLongDesc;
	}

	public String getApparelSizeShortDesc() {
		return this.apparelSizeShortDesc;
	}

	public void setApparelSizeShortDesc(String apparelSizeShortDesc) {
		this.apparelSizeShortDesc = apparelSizeShortDesc;
	}

	public List<LadiesApparel> getLadiesApparels() {
		return this.ladiesApparels;
	}

	public void setLadiesApparels(List<LadiesApparel> ladiesApparels) {
		this.ladiesApparels = ladiesApparels;
	}

	public LadiesApparel addLadiesApparel(LadiesApparel ladiesApparel) {
		getLadiesApparels().add(ladiesApparel);
		ladiesApparel.setApparelSizeCdtb(this);

		return ladiesApparel;
	}

	public LadiesApparel removeLadiesApparel(LadiesApparel ladiesApparel) {
		getLadiesApparels().remove(ladiesApparel);
		ladiesApparel.setApparelSizeCdtb(null);

		return ladiesApparel;
	}

}