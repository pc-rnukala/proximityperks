package com.proximityperks.data.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.proximityperks.data.User;

/**
 * @author rnukala
 * 
 */
@Entity
@Table(name = "USER")
public class UserImpl implements User {

	private Long id;
	private Date createdDate;
	private Date updatedDate;
	private String modoAccountId;
	private String password;
	private String phoneNumber;
	private String userGuid;
	private String userName;

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#getId()
	 */
	@Override
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#getCreatedDate()
	 */
	@Override
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#setCreatedDate(java.util.Date)
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#getUpdatedDate()
	 */
	@Override
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#getModoAccountId()
	 */
	@Override
	@Column(name = "modo_account_id")
	public String getModoAccountId() {
		return modoAccountId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#setModoAccountId(java.lang.String)
	 */
	@Override
	public void setModoAccountId(String modoAccountId) {
		this.modoAccountId = modoAccountId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#getPassword()
	 */
	@Override
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#getPhoneNumber()
	 */
	@Override
	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#setPhoneNumber(java.lang.String)
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#getUserGuid()
	 */
	@Override
	@Column(name = "user_guid")
	public String getUserGuid() {
		return userGuid;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#setUserGuid(java.lang.String)
	 */
	@Override
	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#getUserName()
	 */
	@Override
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.User#setUserName(java.lang.String)
	 */
	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
