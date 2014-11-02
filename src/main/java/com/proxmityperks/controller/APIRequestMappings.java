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
	
	public static final String LOGIN_USER="/api/login/loginUser";
	public static final String SWITCH_USER="/api/login/switchUser";
	public static final String LOGOUT_USER="/api/login/logoutUser";
	public static final String CREATE_USER="/api/login/createUser";

}
