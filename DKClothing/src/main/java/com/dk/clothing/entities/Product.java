package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int productId;

	@Temporal(TemporalType.DATE)
	@Column(name="cret_date")
	private Date cretDate;

	@Column(name="cret_uid")
	private String cretUid;
	
	@Temporal(TemporalType.DATE)
	@Column(name="updt_date")
	private Date updtDate;
	
	@Column(name="updt_uid")
	private String updtUid;
	
	@Column(name="included_year")
	@NotNull
	private Integer includedYear;

	@Column(name="price_per_unit")
	@NotNull
	private Float pricePerUnit;

	@Column(name="total_items")
	@NotNull
	private Integer totalItems;

	//bi-directional many-to-one association to Denim
	@OneToMany(mappedBy="product")
	private List<Denim> denims;

	//bi-directional many-to-one association to LadiesApparel
	@OneToMany(mappedBy="product")
	private List<LadiesApparel> ladiesApparels;

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
	@OneToMany(mappedBy="product")
	private List<ProductsImage> productsImages;

	//bi-directional many-to-one association to Sock
	@OneToMany(mappedBy="product")
	private List<Sock> socks;

	public Product() {
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Date getCretDate() {
		return this.cretDate;
	}

	public void setCretDate(Date cretDate) {
		this.cretDate = cretDate;
	}

	public String getCretUid() {
		return this.cretUid;
	}

	public void setCretUid(String cretUid) {
		this.cretUid = cretUid;
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

	public List<Denim> getDenims() {
		return this.denims;
	}

	public void setDenims(List<Denim> denims) {
		this.denims = denims;
	}

	public Denim addDenim(Denim denim) {
		getDenims().add(denim);
		denim.setProduct(this);

		return denim;
	}

	public Denim removeDenim(Denim denim) {
		getDenims().remove(denim);
		denim.setProduct(null);

		return denim;
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
	
	public Date getUpdtDate() {
		return updtDate;
	}

	public void setUpdtDate(Date updtDate) {
		this.updtDate = updtDate;
	}

	public String getUpdtUid() {
		return updtUid;
	}

	public void setUpdtUid(String updtUid) {
		this.updtUid = updtUid;
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

}