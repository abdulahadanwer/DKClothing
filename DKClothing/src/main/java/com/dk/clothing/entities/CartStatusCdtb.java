package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cart_status_cdtb database table.
 * 
 */
@Entity
@Table(name="cart_status_cdtb")
@NamedQuery(name="CartStatusCdtb.findAll", query="SELECT c FROM CartStatusCdtb c")
public class CartStatusCdtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cart_status_cd")
	private String cartStatusCd;

	@Column(name="cart_status_long_desc")
	private String cartStatusLongDesc;

	@Column(name="cart_status_short_desc")
	private String cartStatusShortDesc;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="cartStatusCdtb")
	private List<Cart> carts;

	public CartStatusCdtb() {
	}

	public String getCartStatusCd() {
		return this.cartStatusCd;
	}

	public void setCartStatusCd(String cartStatusCd) {
		this.cartStatusCd = cartStatusCd;
	}

	public String getCartStatusLongDesc() {
		return this.cartStatusLongDesc;
	}

	public void setCartStatusLongDesc(String cartStatusLongDesc) {
		this.cartStatusLongDesc = cartStatusLongDesc;
	}

	public String getCartStatusShortDesc() {
		return this.cartStatusShortDesc;
	}

	public void setCartStatusShortDesc(String cartStatusShortDesc) {
		this.cartStatusShortDesc = cartStatusShortDesc;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setCartStatusCdtb(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setCartStatusCdtb(null);

		return cart;
	}

}