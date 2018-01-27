package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the legging database table.
 * 
 */
@Entity
@NamedQuery(name="Legging.findAll", query="SELECT l FROM Legging l")
public class Legging implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="legging_id")
	private int leggingId;

	@Column(name="is_sold")
	private String isSold;

	//bi-directional many-to-one association to LeggingSizeCdtb
	@ManyToOne
	@JoinColumn(name="legging_size_cd")
	private LeggingSizeCdtb leggingSizeCdtb;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public Legging() {
	}

	public int getLeggingId() {
		return this.leggingId;
	}

	public void setLeggingId(int leggingId) {
		this.leggingId = leggingId;
	}

	public String getIsSold() {
		return this.isSold;
	}

	public void setIsSold(String isSold) {
		this.isSold = isSold;
	}

	public LeggingSizeCdtb getLeggingSizeCdtb() {
		return this.leggingSizeCdtb;
	}

	public void setLeggingSizeCdtb(LeggingSizeCdtb leggingSizeCdtb) {
		this.leggingSizeCdtb = leggingSizeCdtb;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}