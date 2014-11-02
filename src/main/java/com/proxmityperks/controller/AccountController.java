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

import com.proximityperks.dao.UserAccountDao;
import com.proximityperks.dao.UserDao;
import com.proximityperks.data.User;
import com.proximityperks.data.UserAccount;
import com.proximityperks.data.impl.UserImpl;
import com.proximityperks.model.ProxmityPerksJsonModel;

@Controller
public class AccountController {
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserAccountDao userAccountDao;

	@RequestMapping(value = APIRequestMappings.GET_ACCOUNTS, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel getAccounts(
			@RequestParam(value = "userGuid", required = true) String userGuid) {
		ProxmityPerksJsonModel model = new ProxmityPerksJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		model.setSpHeader(header);
		header.put("status", false);
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		List<String> errorList = new ArrayList<String>();
		User user = userDao.getUserByGuid(userGuid);
		if (user != null) {
			header.put("status", true);
			List<UserAccount> userAccounts = userAccountDao.getAccounts(user
					.getId());
			//data.put("user", user);
			if (userAccounts != null) {
				data.put("accounts", userAccounts);
			} else {
				data.put("accounts", new ArrayList<UserAccount>());
			}
			header.put("userGuid", user.getUserGuid());
		} else {
			errorList.add("Invalid user guid");
			header.put("status", false);
		}
		header.put("errorList", errorList);
		return model;
	}
}
