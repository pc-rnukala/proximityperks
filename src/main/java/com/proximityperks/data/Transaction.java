package com.proximityperks.data;

import java.util.Date;

public interface Transaction {

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract Long getUserAccountId();

	public abstract void setUserAccountId(Long userAccountId);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract String getCategoryName();

	public abstract void setCategoryName(String categoryName);

	public abstract String getMerchantName();

	public abstract void setMerchantName(String merchantName);

	public abstract String getTransactionType();

	public abstract void setTransactionType(String transactionType);

	public abstract Double getTransactionAmount();

	public abstract void setTransactionAmount(Double transactionAmount);

	public abstract String getIntuitTransactionId();

	public abstract void setIntuitTransactionId(String intuitTransactionId);

	public abstract Integer getMerchantSum();

	public abstract void setMerchantSum(Integer merchantSum);

	public abstract Integer getMerchantCount();

	public abstract void setMerchantCount(Integer merchantCount);

	public abstract Date getTransactionDate();

	public abstract void setTransactionDate(Date transactionDate);

	public abstract Integer getRank();

	public abstract void setRank(Integer rank);

	public abstract Date getCreatedDate();

	public abstract void setCreatedDate(Date createdDate);

	public abstract Date getUpdatedDate();

	public abstract void setUpdatedDate(Date updatedDate);

}