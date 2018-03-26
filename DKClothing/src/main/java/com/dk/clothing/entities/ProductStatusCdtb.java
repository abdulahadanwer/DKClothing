package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_status_cdtb database table.
 * 
 */
@Entity
@Table(name="product_status_cdtb")
@NamedQuery(name="ProductStatusCdtb.findAll", query="SELECT p FROM ProductStatusCdtb p")
public class ProductStatusCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_status_cd")
	private String productStatusCd;

	@Column(name="product_status_long_desc")
	private String productStatusLongDesc;

	@Column(name="product_status_short_descc")
	private String productStatusShortDescc;

	public ProductStatusCdtb() {
	}

	public String getProductStatusCd() {
		return this.productStatusCd;
	}

	public void setProductStatusCd(String productStatusCd) {
		this.productStatusCd = productStatusCd;
	}

	public String getProductStatusLongDesc() {
		return this.productStatusLongDesc;
	}

	public void setProductStatusLongDesc(String productStatusLongDesc) {
		this.productStatusLongDesc = productStatusLongDesc;
	}

	public String getProductStatusShortDescc() {
		return this.productStatusShortDescc;
	}

	public void setProductStatusShortDescc(String productStatusShortDescc) {
		this.productStatusShortDescc = productStatusShortDescc;
	}

}