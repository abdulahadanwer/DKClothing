package com.dk.clothing.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@Column(name="active_ind")
	private String activeInd;

	@Temporal(TemporalType.DATE)
	@Column(name="cret_date")
	private Date cretDate;

	@Column(name="cret_uid")
	private String cretUid;

	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="updt_date")
	private Date updtDate;

	@Column(name="updt_uid")
	private String updtUid;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to UserDetail
	@OneToMany(mappedBy="user")
	private List<UserDetail> userDetails;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="users_roles"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<Role> roles;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getActiveInd() {
		return this.activeInd;
	}

	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public UserDetail addUserDetail(UserDetail userDetail) {
		getUserDetails().add(userDetail);
		userDetail.setUser(this);

		return userDetail;
	}

	public UserDetail removeUserDetail(UserDetail userDetail) {
		getUserDetails().remove(userDetail);
		userDetail.setUser(null);

		return userDetail;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}