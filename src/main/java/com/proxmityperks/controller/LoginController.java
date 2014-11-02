package com.proxmityperks.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proximityperks.dao.UserDao;
import com.proximityperks.data.User;
import com.proximityperks.data.impl.UserImpl;
import com.proximityperks.model.ProxmityPerksJsonModel;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = APIRequestMappings.LOGIN_USER, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel loginUser(
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = true) String password) {
		ProxmityPerksJsonModel model = new ProxmityPerksJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		model.setSpHeader(header);
		header.put("status", false);
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		List<String> errorList = new ArrayList<String>();
		User user = userDao.getUser(userName);
		if (user != null && user.getPassword().equals(password)) {
			header.put("status", true);
			data.put("user", user);
			header.put("userGuid", user.getUserGuid());
		} else {
			errorList.add("Invalid user name/password");
			header.put("status", false);
		}
		header.put("errorList", errorList);
		return model;
	}

	@RequestMapping(value = APIRequestMappings.SWITCH_USER, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel switchUser(
			@RequestParam(value = "userGuid", required = true) String userGuid) {
		ProxmityPerksJsonModel model = new ProxmityPerksJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		model.setSpHeader(header);
		header.put("status", true);
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		return model;
	}

	@RequestMapping(value = APIRequestMappings.LOGOUT_USER, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel logoutUser(
			@RequestParam(value = "userGuid", required = true) String userGuid) {
		ProxmityPerksJsonModel model = new ProxmityPerksJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		model.setSpHeader(header);
		header.put("status", true);
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		return model;
	}

	@RequestMapping(value = APIRequestMappings.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel createUser(
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "phoneNumber", required = true) String phoneNumber) {
		ProxmityPerksJsonModel model = new ProxmityPerksJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		model.setSpHeader(header);
		header.put("status", false);
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		String modoAccountId = UUID.randomUUID().toString();
		User user = this.createUser(userName, password, modoAccountId,
				phoneNumber);
		List<String> errorList = new ArrayList<String>();
		if (user != null) {
			header.put("status", true);
			data.put("user", user);
			header.put("userGuid", user.getUserGuid());
		} else {
			errorList.add("Failed to create user");
			header.put("status", false);
		}

		return model;
	}

	/**
	 * Create user from the input
	 * 
	 * @param userName
	 * @param password
	 * @param modoAccountId
	 * @return
	 */
	public User createUser(String userName, String password,
			String modoAccountId, String phoneNumber) {
		User user = new UserImpl();
		user.setCreatedDate(new DateTime().toDate());
		user.setUpdatedDate(new DateTime().toDate());
		user.setModoAccountId(modoAccountId);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setUpdatedDate(new DateTime().toDate());
		user.setUserGuid(UUID.randomUUID().toString());
		user.setUserName(userName);
		User createdUser = userDao.saveOrUpdate(user);
		return createdUser;
	}
}
