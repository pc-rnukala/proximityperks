package com.proximityperks.dao;

import java.util.List;

import com.proximityperks.data.UserAccount;

public interface UserAccountDao {
	public List<UserAccount> getAccounts(Long userId);
	
}
