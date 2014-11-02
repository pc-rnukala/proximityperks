package com.proximityperks.modo.delegate;

public class OfferRequest {

	public static final String ACCOUNT_ID = "account_id";
	public static final String MERCHANT_ID = "merchant_id";
	public static final String LOCATION_ID = "location_id";
	public static final String STATUS_FILTER = "status_filter";
	public static final String GIVER_FILTER = "giver_filter";
	public static final String SHOULD_INCLUDE_GIVEN = "should_include_given";

	private String merchantId;
	private String accountId;
	private String locationId;
	private String statusFilter;
	private String giverFilter;
	private int shouldIncludeGiven;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getStatusFilter() {
		return statusFilter;
	}

	public void setStatusFilter(String statusFilter) {
		this.statusFilter = statusFilter;
	}

	public String getGiverFilter() {
		return giverFilter;
	}

	public void setGiverFilter(String giverFilter) {
		this.giverFilter = giverFilter;
	}

	public int getShouldIncludeGiven() {
		return shouldIncludeGiven;
	}

	public void setShouldIncludeGiven(int shouldIncludeGiven) {
		this.shouldIncludeGiven = shouldIncludeGiven;
	}

}
