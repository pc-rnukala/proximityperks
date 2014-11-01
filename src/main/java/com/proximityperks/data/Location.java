package com.proximityperks.data;

import java.util.Date;

public interface Location {

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getModoLocationId();

	public abstract void setModoLocationId(String modoLocationId);

	public abstract Date getCreatedDate();

	public abstract void setCreatedDate(Date createdDate);

	public abstract Date getUpdatedDate();

	public abstract void setUpdatedDate(Date updatedDate);

}