package com.proximityperks.dao;

import java.util.List;

import com.proximityperks.data.Transaction;
import com.proximityperks.data.User;
import com.proximityperks.modo.delegate.MerchantLocation;

public interface UserTransactionDao {
	public List<Transaction> getUserTransactions(List<Long> userAccountIds);

	public List<MerchantLocation> getMerchantLocations(User user);
}
