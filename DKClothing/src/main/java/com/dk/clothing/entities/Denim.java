package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the denim database table.
 * 
 */
@Entity
@NamedQuery(name="Denim.findAll", query="SELECT d FROM Denim d")
public class Denim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="denim_id")
	private int denimId;

	@Column(name="is_sold")
	private String isSold;

	//bi-directional many-to-one association to DenimSizeCdtb
	@ManyToOne
	@JoinColumn(name="denim_size_cd")
	private DenimSizeCdtb denimSizeCdtb;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public Denim() {
	}

	public int getDenimId() {
		return this.denimId;
	}

	public void setDenimId(int denimId) {
		this.denimId = denimId;
	}

	public String getIsSold() {
		return this.isSold;
	}

	public void setIsSold(String isSold) {
		this.isSold = isSold;
	}

	public DenimSizeCdtb getDenimSizeCdtb() {
		return this.denimSizeCdtb;
	}

	public void setDenimSizeCdtb(DenimSizeCdtb denimSizeCdtb) {
		this.denimSizeCdtb = denimSizeCdtb;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}