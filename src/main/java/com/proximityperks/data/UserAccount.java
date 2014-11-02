package com.proximityperks.data;

import java.util.Date;

public interface UserAccount {

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract Long getUserId();

	public abstract void setUserId(Long userId);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getFirmName();

	public abstract void setFirmName(String firmName);

	public abstract Double getBalance();

	public abstract void setBalance(Double balance);

	public abstract String getIntuitAccountId();

	public abstract void setIntuitAccountId(String intuitAccountId);

	public abstract Date getCreatedDate();

	public abstract void setCreatedDate(Date createdDate);

	public abstract Date getUpdatedDate();

	public abstract void setUpdatedDate(Date updatedDate);

	public abstract Date getDeletedDate();

	public abstract void setDeletedDate(Date deletedDate);
	public String getAmount();

}