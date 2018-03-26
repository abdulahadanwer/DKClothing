package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the ladies_denim database table.
 * 
 */
@Entity
@Table(name="ladies_denim")
@NamedQuery(name="LadiesDenim.findAll", query="SELECT l FROM LadiesDenim l")
public class LadiesDenim extends Code implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="denim_id")
	private int denimId;

	//bi-directional many-to-one association to LadiesDenimSizeCdtb
	@ManyToOne
	@JoinColumn(name="product_status_cd")
	private ProductStatusCdtb productStatusCdtb;

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

	public ProductStatusCdtb getProductStatusCdtb() {
		return productStatusCdtb;
	}

	public void setProductStatusCdtb(ProductStatusCdtb productStatusCdtb) {
		this.productStatusCdtb = productStatusCdtb;
	}

}