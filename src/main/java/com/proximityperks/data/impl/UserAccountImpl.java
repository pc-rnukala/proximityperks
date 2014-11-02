package com.proximityperks.data.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.proximityperks.data.UserAccount;
import com.proximityperks.util.ProximityPerksUtil;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccountImpl implements UserAccount {

	private Long id;
	private Long userId;
	private String name;
	private String firmName;
	private Double balance;
	private String intuitAccountId;
	private Date createdDate;
	private Date updatedDate;
	private Date deletedDate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getId()
	 */
	@Override
	@Id
	@Column(name = "user_account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("userAccountId")
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getUserId()
	 */
	@Override
	@Column(name = "user_id")
	@JsonIgnore
	public Long getUserId() {
		return userId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#setUserId(java.lang.Long)
	 */
	@Override
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getName()
	 */
	@Override
	@Column(name = "name")
	@JsonProperty("userAccountName")
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getFirmName()
	 */
	@Override
	@Column(name = "firm_name")
	public String getFirmName() {
		return firmName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.UserAccount#setFirmName(java.lang.String)
	 */
	@Override
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getBalance()
	 */
	@Override
	@Column(name = "balance")
	@JsonIgnore
	public Double getBalance() {
		return balance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.UserAccount#setBalance(java.lang.Double)
	 */
	@Override
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getIntuitAccountId()
	 */
	@Override
	@Column(name = "intuit_account_id")
	@JsonIgnore
	public String getIntuitAccountId() {
		return intuitAccountId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.UserAccount#setIntuitAccountId(java.lang
	 * .String)
	 */
	@Override
	public void setIntuitAccountId(String intuitAccountId) {
		this.intuitAccountId = intuitAccountId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getCreatedDate()
	 */
	@Override
	@Column(name = "created_date")
	@JsonIgnore
	public Date getCreatedDate() {
		return createdDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.UserAccount#setCreatedDate(java.util.Date)
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getUpdatedDate()
	 */
	@Override
	@Column(name = "updated_date")
	@JsonIgnore
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.UserAccount#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.UserAccount#getDeletedDate()
	 */
	@Override
	@Column(name = "deleted_date")
	@JsonIgnore
	public Date getDeletedDate() {
		return deletedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.UserAccount#setDeletedDate(java.util.Date)
	 */
	@Override
	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Transient
	public Double getAmount() {
		return this.balance;
	}
}
