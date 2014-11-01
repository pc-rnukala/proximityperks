package com.proximityperks.data.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.proximityperks.data.Transaction;

@Entity
@Table(name = "TRANSACTION")
public class TransactionImpl implements Transaction {

	private Long id;
	private Long userAccountId;
	private String description;
	private String categoryName;
	private String merchantName;
	private String transactionType;
	private Double transactionAmount;
	private String intuitTransactionId;
	private Integer merchantSum;
	private Integer merchantCount;
	private Date transactionDate;
	private Integer rank;
	private Date createdDate;
	private Date updatedDate;

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getId()
	 */
	@Override
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getUserAccountId()
	 */
	@Override
	@Column(name = "user_account_id")
	public Long getUserAccountId() {
		return userAccountId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setUserAccountId(java.lang.Long)
	 */
	@Override
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getDescription()
	 */
	@Override
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getCategoryName()
	 */
	@Override
	@Column(name = "category_name")
	public String getCategoryName() {
		return categoryName;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setCategoryName(java.lang.String)
	 */
	@Override
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getMerchantName()
	 */
	@Override
	@Column(name = "merchant_name")
	public String getMerchantName() {
		return merchantName;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setMerchantName(java.lang.String)
	 */
	@Override
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getTransactionType()
	 */
	@Override
	@Column(name = "transaction_type")
	public String getTransactionType() {
		return transactionType;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setTransactionType(java.lang.String)
	 */
	@Override
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getTransactionAmount()
	 */
	@Override
	@Column(name = "transaction_amount")
	public Double getTransactionAmount() {
		return transactionAmount;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setTransactionAmount(java.lang.Double)
	 */
	@Override
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getIntuitTransactionId()
	 */
	@Override
	@Column(name = "intuit_transaction_id")
	public String getIntuitTransactionId() {
		return intuitTransactionId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setIntuitTransactionId(java.lang.String)
	 */
	@Override
	public void setIntuitTransactionId(String intuitTransactionId) {
		this.intuitTransactionId = intuitTransactionId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getMerchantSum()
	 */
	@Override
	@Column(name = "merchant_sum")
	public Integer getMerchantSum() {
		return merchantSum;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setMerchantSum(java.lang.Integer)
	 */
	@Override
	public void setMerchantSum(Integer merchantSum) {
		this.merchantSum = merchantSum;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getMerchantCount()
	 */
	@Override
	@Column(name = "merchant_count")
	public Integer getMerchantCount() {
		return merchantCount;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setMerchantCount(java.lang.Integer)
	 */
	@Override
	public void setMerchantCount(Integer merchantCount) {
		this.merchantCount = merchantCount;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getTransactionDate()
	 */
	@Override
	@Column(name = "transaction_date")
	public Date getTransactionDate() {
		return transactionDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setTransactionDate(java.util.Date)
	 */
	@Override
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getRank()
	 */
	@Override
	@Column(name = "rank")
	public Integer getRank() {
		return rank;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setRank(java.lang.Integer)
	 */
	@Override
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getCreatedDate()
	 */
	@Override
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setCreatedDate(java.util.Date)
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#getUpdatedDate()
	 */
	@Override
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Transaction#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
