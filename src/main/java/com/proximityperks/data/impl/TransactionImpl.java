package com.proximityperks.data.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.proximityperks.data.Transaction;
import com.proximityperks.util.ProximityPerksUtil;

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
	private Date transDate;
	private Integer rank;
	private Date createdDate;
	private Date updatedDate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getId()
	 */
	@Override
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("transactionId")
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getUserAccountId()
	 */
	@Override
	@Column(name = "user_account_id")
	@JsonIgnore
	public Long getUserAccountId() {
		return userAccountId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setUserAccountId(java.lang.Long)
	 */
	@Override
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getDescription()
	 */
	@Override
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getCategoryName()
	 */
	@Override
	@Column(name = "category_name")
	public String getCategoryName() {
		return categoryName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setCategoryName(java.lang.String
	 * )
	 */
	@Override
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getMerchantName()
	 */
	@Override
	@Column(name = "merchant_name")
	public String getMerchantName() {
		return merchantName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setMerchantName(java.lang.String
	 * )
	 */
	@Override
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getTransactionType()
	 */
	@Override
	@Column(name = "transaction_type")
	@JsonIgnore
	public String getTransactionType() {
		return transactionType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setTransactionType(java.lang
	 * .String)
	 */
	@Override
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getTransactionAmount()
	 */
	@Override
	@Column(name = "transaction_amount")
	@JsonIgnore
	public Double getTransactionAmount() {
		return transactionAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setTransactionAmount(java.lang
	 * .Double)
	 */
	@Override
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getIntuitTransactionId()
	 */
	@Override
	@Column(name = "intuit_transaction_id")
	@JsonIgnore
	public String getIntuitTransactionId() {
		return intuitTransactionId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setIntuitTransactionId(java.
	 * lang.String)
	 */
	@Override
	public void setIntuitTransactionId(String intuitTransactionId) {
		this.intuitTransactionId = intuitTransactionId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getMerchantSum()
	 */
	@Override
	@Column(name = "merchant_sum")
	@JsonIgnore
	public Integer getMerchantSum() {
		return merchantSum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setMerchantSum(java.lang.Integer
	 * )
	 */
	@Override
	public void setMerchantSum(Integer merchantSum) {
		this.merchantSum = merchantSum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getMerchantCount()
	 */
	@Override
	@Column(name = "merchant_count")
	@JsonIgnore
	public Integer getMerchantCount() {
		return merchantCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setMerchantCount(java.lang.Integer
	 * )
	 */
	@Override
	public void setMerchantCount(Integer merchantCount) {
		this.merchantCount = merchantCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getTransactionDate()
	 */
	@Override
	@Column(name = "transaction_date")
	@JsonIgnore
	public Date getTransDate() {
		return transDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.proximityperks.data.impl.Transaction#setTransactionDate(java.util
	 * .Date)
	 */
	@Override
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getRank()
	 */
	@Override
	@Column(name = "rank")
	@JsonIgnore
	public Integer getRank() {
		return rank;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#setRank(java.lang.Integer)
	 */
	@Override
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getCreatedDate()
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
	 * com.proximityperks.data.impl.Transaction#setCreatedDate(java.util.Date)
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.proximityperks.data.impl.Transaction#getUpdatedDate()
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
	 * com.proximityperks.data.impl.Transaction#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Transient
	public String getTransactionDate() {
		return ProximityPerksUtil.getFormattedDate(transDate);
	}

	@Transient
	public Double getAmount() {
		return transactionAmount;
	}

	@Transient
	@JsonProperty("isCredit")
	public boolean isCredit() {
		return false;
	}

	/*
	 * public JsonObject toJson() { JsonObject json = new JsonObject();
	 * json.addProperty("transactionId", String.valueOf(this.id));
	 * json.addProperty("transactionDate",
	 * ProximityPerksUtil.getFormattedDate(transactionDate));
	 * json.addProperty("description", String.valueOf(this.description));
	 * json.addProperty("amount",
	 * ProximityPerksUtil.getFormattedAmount(transactionAmount));
	 * json.addProperty("isCredit", String.valueOf("false"));
	 * json.addProperty("merchantName", merchantName); return json; }
	 */

	/*
	 * public String toJson() { ObjectMapper mapper = new ObjectMapper();
	 * Map<String, String> json = new HashMap<String, String>();
	 * json.put("transactionId", String.valueOf(this.id));
	 * json.put("transactionDate",
	 * ProximityPerksUtil.getFormattedDate(transactionDate));
	 * json.put("description", String.valueOf(this.description));
	 * json.put("amount",
	 * ProximityPerksUtil.getFormattedAmount(transactionAmount));
	 * json.put("isCredit", String.valueOf("false")); json.put("merchantName",
	 * merchantName); String jsonStr = null; try { jsonStr =
	 * mapper.writeValueAsString(json); } catch (JsonProcessingException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } return jsonStr; }
	 */

}
