package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ladies_apparel database table.
 * 
 */
@Entity
@Table(name="ladies_apparel")
@NamedQuery(name="LadiesApparel.findAll", query="SELECT l FROM LadiesApparel l")
public class LadiesApparel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ladies_apparel_id")
	private int ladiesApparelId;

	@Column(name="is_sold")
	private String isSold;

	//bi-directional many-to-one association to ApparelSizeCdtb
	@ManyToOne
	@JoinColumn(name="apparel_size_cd")
	private ApparelSizeCdtb apparelSizeCdtb;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public LadiesApparel() {
	}

	public int getLadiesApparelId() {
		return this.ladiesApparelId;
	}

	public void setLadiesApparelId(int ladiesApparelId) {
		this.ladiesApparelId = ladiesApparelId;
	}

	public String getIsSold() {
		return this.isSold;
	}

	public void setIsSold(String isSold) {
		this.isSold = isSold;
	}

	public ApparelSizeCdtb getApparelSizeCdtb() {
		return this.apparelSizeCdtb;
	}

	public void setApparelSizeCdtb(ApparelSizeCdtb apparelSizeCdtb) {
		this.apparelSizeCdtb = apparelSizeCdtb;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}