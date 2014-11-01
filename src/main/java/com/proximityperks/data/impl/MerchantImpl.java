package com.proximityperks.data.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.proximityperks.data.Merchant;

@Entity
@Table(name = "MERCHANT")
public class MerchantImpl implements Merchant {

	private Long id;
	private String name;
	private String modoMerchantId;
	private Date createdDate;
	private Date updatedDate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#getId()
	 */
	@Override
	@Id
	@Column(name = "merchant_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#getName()
	 */
	@Override
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#getModoMerchantId()
	 */
	@Override
	@Column(name = "modo_merchant_id")
	public String getModoMerchantId() {
		return modoMerchantId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Merchant#setModoMerchantId(java.lang.String)
	 */
	@Override
	public void setModoMerchantId(String modoMerchantId) {
		this.modoMerchantId = modoMerchantId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#getCreatedDate()
	 */
	@Override
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#setCreatedDate(java.util.Date)
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#getUpdatedDate()
	 */
	@Override
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Merchant#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
