package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends Code implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Integer productId;

	@Column(name="included_year")
	private Integer includedYear;

	@Column(name="price_per_unit")
	private Float pricePerUnit;

	@Column(name="total_items")
	private Integer totalItems;

	//bi-directional many-to-one association to LadiesApparel
	@OneToMany(mappedBy="product")
	private List<LadiesApparel> ladiesApparels;

	//bi-directional many-to-one association to LadiesDenim
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LadiesDenim> ladiesDenims;

	//bi-directional many-to-one association to Legging
	@OneToMany(mappedBy="product")
	private List<Legging> leggings;

	//bi-directional many-to-one association to ProductsColorCdtb
	@ManyToOne
	@JoinColumn(name="color_cd")
	private ProductsColorCdtb productsColorCdtb;

	//bi-directional many-to-one association to ProductsCdtb
	@ManyToOne
	@JoinColumn(name="product_cd")
	private ProductsCdtb productsCdtb;

	//bi-directional many-to-one association to SexCdtb
	@ManyToOne
	@JoinColumn(name="sex_cd")
	private SexCdtb sexCdtb;

	//bi-directional many-to-one association to ProductsImage
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductsImage> productsImages;

	//bi-directional many-to-one association to Sock
	@OneToMany(mappedBy="product")
	private List<Sock> socks;
	
	//transient variable to store size in denim table
	private transient Integer ladiesDenimSizeCd;

	public Product() {
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getIncludedYear() {
		return this.includedYear;
	}

	public void setIncludedYear(Integer includedYear) {
		this.includedYear = includedYear;
	}

	public Float getPricePerUnit() {
		return this.pricePerUnit;
	}

	public void setPricePerUnit(Float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Integer getTotalItems() {
		return this.totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public List<LadiesApparel> getLadiesApparels() {
		return this.ladiesApparels;
	}

	public void setLadiesApparels(List<LadiesApparel> ladiesApparels) {
		this.ladiesApparels = ladiesApparels;
	}

	public LadiesApparel addLadiesApparel(LadiesApparel ladiesApparel) {
		getLadiesApparels().add(ladiesApparel);
		ladiesApparel.setProduct(this);

		return ladiesApparel;
	}

	public LadiesApparel removeLadiesApparel(LadiesApparel ladiesApparel) {
		getLadiesApparels().remove(ladiesApparel);
		ladiesApparel.setProduct(null);

		return ladiesApparel;
	}

	public List<LadiesDenim> getLadiesDenims() {
		return this.ladiesDenims;
	}

	public void setLadiesDenims(List<LadiesDenim> ladiesDenims) {
		this.ladiesDenims = ladiesDenims;
	}

	public LadiesDenim addLadiesDenim(LadiesDenim ladiesDenim) {
		getLadiesDenims().add(ladiesDenim);
		ladiesDenim.setProduct(this);

		return ladiesDenim;
	}

	public LadiesDenim removeLadiesDenim(LadiesDenim ladiesDenim) {
		getLadiesDenims().remove(ladiesDenim);
		ladiesDenim.setProduct(null);

		return ladiesDenim;
	}

	public List<Legging> getLeggings() {
		return this.leggings;
	}

	public void setLeggings(List<Legging> leggings) {
		this.leggings = leggings;
	}

	public Legging addLegging(Legging legging) {
		getLeggings().add(legging);
		legging.setProduct(this);

		return legging;
	}

	public Legging removeLegging(Legging legging) {
		getLeggings().remove(legging);
		legging.setProduct(null);

		return legging;
	}

	public ProductsColorCdtb getProductsColorCdtb() {
		return this.productsColorCdtb;
	}

	public void setProductsColorCdtb(ProductsColorCdtb productsColorCdtb) {
		this.productsColorCdtb = productsColorCdtb;
	}

	public ProductsCdtb getProductsCdtb() {
		return this.productsCdtb;
	}

	public void setProductsCdtb(ProductsCdtb productsCdtb) {
		this.productsCdtb = productsCdtb;
	}

	public SexCdtb getSexCdtb() {
		return this.sexCdtb;
	}

	public void setSexCdtb(SexCdtb sexCdtb) {
		this.sexCdtb = sexCdtb;
	}

	public List<ProductsImage> getProductsImages() {
		return this.productsImages;
	}

	public void setProductsImages(List<ProductsImage> productsImages) {
		this.productsImages = productsImages;
	}

	public ProductsImage addProductsImage(ProductsImage productsImage) {
		getProductsImages().add(productsImage);
		productsImage.setProduct(this);

		return productsImage;
	}

	public ProductsImage removeProductsImage(ProductsImage productsImage) {
		getProductsImages().remove(productsImage);
		productsImage.setProduct(null);

		return productsImage;
	}

	public List<Sock> getSocks() {
		return this.socks;
	}

	public void setSocks(List<Sock> socks) {
		this.socks = socks;
	}

	public Sock addSock(Sock sock) {
		getSocks().add(sock);
		sock.setProduct(this);

		return sock;
	}

	public Sock removeSock(Sock sock) {
		getSocks().remove(sock);
		sock.setProduct(null);

		return sock;
	}

	public Integer getLadiesDenimSizeCd() {
		return ladiesDenimSizeCd;
	}

	public void setLadiesDenimSizeCd(Integer ladiesDenimSizeCd) {
		this.ladiesDenimSizeCd = ladiesDenimSizeCd;
	}

}