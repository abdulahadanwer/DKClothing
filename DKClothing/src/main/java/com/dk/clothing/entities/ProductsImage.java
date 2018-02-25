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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productsImagesId;

	@Lob
	private byte[] image;
	
	@Column(name="image_file_name")
	private String imageFileName;

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
		
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
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