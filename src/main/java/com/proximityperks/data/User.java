package com.proximityperks.data;

import java.util.Date;

public interface User {

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract Date getCreatedDate();

	public abstract void setCreatedDate(Date createdDate);

	public abstract Date getUpdatedDate();

	public abstract void setUpdatedDate(Date updatedDate);

	public abstract String getModoAccountId();

	public abstract void setModoAccountId(String modoAccountId);

	public abstract String getPassword();

	public abstract void setPassword(String password);

	public abstract String getPhoneNumber();

	public abstract void setPhoneNumber(String phoneNumber);

	public abstract String getUserGuid();

	public abstract void setUserGuid(String userGuid);

	public abstract String getUserName();

	public abstract void setUserName(String userName);

}