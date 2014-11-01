package com.proximityperks.data.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.proximityperks.data.UserPerk;

@Entity
@Table(name = "USER_PERK")
public class UserPerkImpl implements UserPerk {

	private Long id;
	private String modoPerkId;
	private Long userId;
	private String merchantId;
	private String locationId;
	private String perkStatus;
	private String latitude;
	private String longitude;
	private String redemptionDetails;
	private Date createdDate;
	private Date updatedDate;
	private Date deletedDate;

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getId()
	 */
	@Override
	@Id
	@Column(name = "user_perk_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getModoPerkId()
	 */
	@Override
	@Column(name = "modo_perk_id")
	public String getModoPerkId() {
		return modoPerkId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setModoPerkId(java.lang.String)
	 */
	@Override
	public void setModoPerkId(String modoPerkId) {
		this.modoPerkId = modoPerkId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getUserId()
	 */
	@Override
	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setUserId(java.lang.Long)
	 */
	@Override
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getMerchantId()
	 */
	@Override
	@Column(name = "merchant_id")
	public String getMerchantId() {
		return merchantId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setMerchantId(java.lang.String)
	 */
	@Override
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getLocationId()
	 */
	@Override
	@Column(name = "location_id")
	public String getLocationId() {
		return locationId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setLocationId(java.lang.String)
	 */
	@Override
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getPerkStatus()
	 */
	@Override
	@Column(name = "perk_status")
	public String getPerkStatus() {
		return perkStatus;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setPerkStatus(java.lang.String)
	 */
	@Override
	public void setPerkStatus(String perkStatus) {
		this.perkStatus = perkStatus;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getLatitude()
	 */
	@Override
	@Column(name = "latitude")
	public String getLatitude() {
		return latitude;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setLatitude(java.lang.String)
	 */
	@Override
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getLongitude()
	 */
	@Override
	@Column(name = "longitude")
	public String getLongitude() {
		return longitude;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setLongitude(java.lang.String)
	 */
	@Override
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getRedemptionDetails()
	 */
	@Override
	@Column(name = "redemption_details")
	public String getRedemptionDetails() {
		return redemptionDetails;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setRedemptionDetails(java.lang.String)
	 */
	@Override
	public void setRedemptionDetails(String redemptionDetails) {
		this.redemptionDetails = redemptionDetails;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getCreatedDate()
	 */
	@Override
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setCreatedDate(java.util.Date)
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getUpdatedDate()
	 */
	@Override
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#getDeletedDate()
	 */
	@Override
	@Column(name = "deleted_date")
	public Date getDeletedDate() {
		return deletedDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.UserPerk#setDeletedDate(java.util.Date)
	 */
	@Override
	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

}
