package com.proximityperks.dao;

import java.util.List;

import javax.transaction.UserTransaction;

public interface UserTransactionDao {
	public List<UserTransaction> getUserTransactions(List<Long> userAccountIds);
}
