package com.proxmityperks.controller;

public class APIRequestMappings {

	public static final String DUMMY_EMP = "/rest/emp/dummy";
	public static final String GET_EMP = "/rest/emp/{id}";
	public static final String GET_ALL_EMP = "/rest/emps";
	public static final String CREATE_EMP = "/rest/emp/create";
	public static final String DELETE_EMP = "/rest/emp/delete/{id}";

	/**
	 * Login controller
	 */

	public static final String LOGIN_USER = "/api/login/loginUser";
	public static final String SWITCH_USER = "/api/login/switchUser";
	public static final String LOGOUT_USER = "/api/login/logoutUser";
	public static final String CREATE_USER = "/api/login/createUser";

	/**
	 * Account controller
	 */
	public static final String GET_ACCOUNTS = "/api/account/getAccounts";

	/**
	 * Transaction controller
	 */
	public static final String GET_TRANSACTIONS = "/api/transaction/getTransactions";

	// Perk Controller
	public static final String GET_PERKS = "/api/perk/getPerks";
	public static final String REDEEM_PERKS = "/api/perk/redeemPerks";
	public static final String VISIT_PERK_LOCATION = "/api/perk/visitPerkLocation";
}
