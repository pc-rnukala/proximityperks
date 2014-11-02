package com.proximityperks.modo.delegate;

public class LocationVisitRequest {

	public static final String MERCHANT_ID = "merchant_id";
	public static final String ACCOUNT_ID = "account_id";
	public static final String LOCATION_ID = "location_id";
	public static final String FUNDING_SOURCES = "funding_sources";

	private String merchantId;
	private String accountId;
	private String locationId;
	private String fundingSource;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getFundingSource() {
		return fundingSource;
	}

	public void setFundingSource(String fundingSource) {
		this.fundingSource = fundingSource;
	}

}
