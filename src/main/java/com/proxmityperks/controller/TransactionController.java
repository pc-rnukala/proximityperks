package com.proxmityperks.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.UserTransaction;

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
import com.proximityperks.dao.UserTransactionDao;
import com.proximityperks.data.Transaction;
import com.proximityperks.data.User;
import com.proximityperks.data.UserAccount;
import com.proximityperks.model.ProxmityPerksJsonModel;

@Controller
public class TransactionController {
	private static final Logger logger = LoggerFactory
			.getLogger(TransactionController.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserAccountDao userAccountDao;

	@Autowired
	private UserTransactionDao userTransactionDao;

	@RequestMapping(value = APIRequestMappings.GET_TRANSACTIONS, method = RequestMethod.POST)
	public @ResponseBody
	ProxmityPerksJsonModel getTransactions(
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
			List<Long> userAccountIds = new ArrayList<Long>();
			List<Transaction> userTransactions = null;
			if (userAccounts != null) {
				for (UserAccount userAccount : userAccounts) {
					userAccountIds.add(userAccount.getId());
				}
				userTransactions = userTransactionDao
						.getUserTransactions(userAccountIds);
			}
			if (userTransactions != null) {
				data.put("transactions", userTransactions);
			} else {
				data.put("transactions", new ArrayList<UserTransaction>());
			}
			// data.put("user", user);
			header.put("userGuid", user.getUserGuid());
		} else {
			errorList.add("Invalid user guid");
			header.put("status", false);
		}
		header.put("errorList", errorList);
		return model;
	}

	/*private List<String> convertListToJson(List<Transaction> userTransactions) {
		List<String> array = new ArrayList<String>();
		for (Transaction userTransaction : userTransactions) {
			array.add(userTransaction.toJson());
		}
		return array;
	}*/
}
