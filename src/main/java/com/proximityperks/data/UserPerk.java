package com.proximityperks.data;

import java.util.Date;

public interface UserPerk {

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract String getModoPerkId();

	public abstract void setModoPerkId(String modoPerkId);

	public abstract Long getUserId();

	public abstract void setUserId(Long userId);

	public abstract String getMerchantId();

	public abstract void setMerchantId(String merchantId);

	public abstract String getLocationId();

	public abstract void setLocationId(String locationId);

	public abstract String getPerkStatus();

	public abstract void setPerkStatus(String perkStatus);

	public abstract String getLatitude();

	public abstract void setLatitude(String latitude);

	public abstract String getLongitude();

	public abstract void setLongitude(String longitude);

	public abstract String getRedemptionDetails();

	public abstract void setRedemptionDetails(String redemptionDetails);

	public abstract Date getCreatedDate();

	public abstract void setCreatedDate(Date createdDate);

	public abstract Date getUpdatedDate();

	public abstract void setUpdatedDate(Date updatedDate);

	public abstract Date getDeletedDate();

	public abstract void setDeletedDate(Date deletedDate);

}