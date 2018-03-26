package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_detail database table.
 * 
 */
@Entity
@Table(name="user_detail")
@NamedQuery(name="UserDetail.findAll", query="SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_detail_id")
	private int userDetailId;

	@Temporal(TemporalType.DATE)
	@Column(name="cret_date")
	private Date cretDate;

	@Column(name="cret_uid")
	private String cretUid;

	@Column(name="email_address")
	private String emailAddress;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	@Temporal(TemporalType.DATE)
	@Column(name="updt_date")
	private Date updtDate;

	@Column(name="updt_uid")
	private String updtUid;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="userDetail")
	private List<Address> addresses;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="userDetail")
	private List<Cart> carts;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserDetail() {
	}

	public int getUserDetailId() {
		return this.userDetailId;
	}

	public void setUserDetailId(int userDetailId) {
		this.userDetailId = userDetailId;
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

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUserDetail(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUserDetail(null);

		return address;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setUserDetail(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setUserDetail(null);

		return cart;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}