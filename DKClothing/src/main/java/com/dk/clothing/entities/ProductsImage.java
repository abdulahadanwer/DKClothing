package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the products_images database table.
 * 
 */
@Entity
@Table(name="products_images")
@NamedQuery(name="ProductsImage.findAll", query="SELECT p FROM ProductsImage p")
public class ProductsImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="products_images_id")
	private int productsImagesId;

	@Lob
	private byte[] image;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ProductsImage() {
	}

	public int getProductsImagesId() {
		return this.productsImagesId;
	}

	public void setProductsImagesId(int productsImagesId) {
		this.productsImagesId = productsImagesId;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}