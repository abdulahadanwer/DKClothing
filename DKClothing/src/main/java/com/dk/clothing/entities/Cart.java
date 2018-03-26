package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cart_id")
	private int cartId;

	@Temporal(TemporalType.DATE)
	@Column(name="cret_date")
	private Date cretDate;

	@Column(name="cret_uid")
	private String cretUid;

	@Column(name="denim_id")
	private int denimId;

	@Temporal(TemporalType.DATE)
	@Column(name="updt_date")
	private Date updtDate;

	@Column(name="updt_uid")
	private String updtUid;

	//bi-directional many-to-one association to CartStatusCdtb
	@ManyToOne
	@JoinColumn(name="cart_status_cd")
	private CartStatusCdtb cartStatusCdtb;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="user_detail_id")
	private UserDetail userDetail;

	public Cart() {
	}

	public int getCartId() {
		return this.cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public int getDenimId() {
		return this.denimId;
	}

	public void setDenimId(int denimId) {
		this.denimId = denimId;
	}

	public Date getUpdtDate() {
		return this.updtDate;
	}

	public void setUpdtDate(Date updtDate) {
		this.updtDate = updtDate;
	}

	public String getUpdtUid() {
		return this.updtUid;
	}

	public void setUpdtUid(String updtUid) {
		this.updtUid = updtUid;
	}

	public CartStatusCdtb getCartStatusCdtb() {
		return this.cartStatusCdtb;
	}

	public void setCartStatusCdtb(CartStatusCdtb cartStatusCdtb) {
		this.cartStatusCdtb = cartStatusCdtb;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}