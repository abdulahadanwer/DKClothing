package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ladies_denim database table.
 * 
 */
@Entity
@Table(name="ladies_denim")
@NamedQuery(name="LadiesDenim.findAll", query="SELECT l FROM LadiesDenim l")
public class LadiesDenim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="denim_id")
	private int denimId;

	@Column(name="is_sold")
	private String isSold;

	//bi-directional many-to-one association to LadiesDenimSizeCdtb
	@ManyToOne
	@JoinColumn(name="ladies_denim_size_cd")
	private LadiesDenimSizeCdtb ladiesDenimSizeCdtb;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public LadiesDenim() {
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

	public LadiesDenimSizeCdtb getLadiesDenimSizeCdtb() {
		return this.ladiesDenimSizeCdtb;
	}

	public void setLadiesDenimSizeCdtb(LadiesDenimSizeCdtb ladiesDenimSizeCdtb) {
		this.ladiesDenimSizeCdtb = ladiesDenimSizeCdtb;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}