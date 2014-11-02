package com.proximityperks.modo.delegate;

public class UserCheckOutRequest {

	private String accountId;
	private String checkoutCode;

	public UserCheckOutRequest() {

	}

	public UserCheckOutRequest(String accountId, String checkoutCode) {
		this.accountId = accountId;
		this.checkoutCode = checkoutCode;

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
}
