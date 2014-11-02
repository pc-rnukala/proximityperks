package com.proximityperks.modo.delegate;

public class LocationCheckoutRequest {

	private String accountId;
	private String checkoutCode;
	private String checkoutAmount;

	public LocationCheckoutRequest() {

	}

	public LocationCheckoutRequest(String accountId, String checkoutCode,
			double checkoutAmount) {
		this.accountId = accountId;
		this.checkoutCode = checkoutCode;
		this.checkoutAmount = String.valueOf(checkoutAmount);
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCheckoutCode() {
		return checkoutCode;
	}

	public void setCheckoutCode(String checkoutCode) {
		this.checkoutCode = checkoutCode;
	}

	public String getCheckoutAmount() {
		return checkoutAmount;
	}

	public void setCheckoutAmount(String checkoutAmount) {
		this.checkoutAmount = checkoutAmount;
	}

}
